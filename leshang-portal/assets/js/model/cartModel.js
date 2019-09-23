/**
 * Created by hans on 2016/10/31.
 * 购物车数据
 */
var cartModel = {

    loadCarts() {
        // 先判断登录状态
        ly.verifyUser().then(res => {
            // 登陆状态，查看本次localStorage是否存有购物车信息
            const localCarts = ly.store.get("carts");
            // 如果本地存有购物车信息，则发送至后台保存，然后删除本地的
            if (localCarts) {
                ly.http.post("/cart/addLocal", localCarts)
                    .then(() => {
                        ly.store.del("carts");
                        this.getCartList();
                    });
            } else {
                this.getCartList();
            }
        }).catch(() => {
            // 未登录
            this.carts = ly.store.get("carts") || [];
            this.selected = this.carts;
        })
    },
    getCartList(){
        ly.http.get("/cart").then(({data}) => {
            // 已登录
            this.carts = data || [];
            this.selectAll = true;
        });
    },
    increment(c) {
        c.num++;
        ly.verifyUser().then(() => {
            // TODO 已登录，向后台发起请求
            ly.http.put("/cart/", ly.stringify({skuId: c.skuId, num: c.num}))
        }).catch(() => {
            // 未登录，直接操作本地数据
            ly.store.set("carts", this.carts);
        })
    },
    decrement(c) {
        if (c.num <= 1) {
            return;
        }
        c.num--;
        ly.verifyUser().then(() => {
            // TODO 已登录，向后台发起请求
            ly.http.put("/cart/", ly.stringify({skuId: c.skuId, num: c.num}))
        }).catch(() => {
            // 未登录，直接操作本地数据
            ly.store.set("carts", this.carts);
        })
    },
    deleteCart(i) {
        ly.verifyUser().then(res => {
            // TODO，已登录购物车
            ly.http.delete("/cart/"+this.carts[i].skuId).then(() => {
                this.carts.splice(i,1)
            })
        }).catch(() => {
            // 未登录购物车
            this.carts.splice(i, 1);
            ly.store.set("carts", this.carts);
        })
    }


};