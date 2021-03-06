const commodity = {
    template: `<div id="content" class="main-content-wrapper">
    <div class="page-content-inner enable-page-sidebar">
        <div class="container-fluid">
            <div class="row shop-sidebar mt-md-2 pt--30 pt-md--15 pt-sm--10 pb--90 pb-md--70 pb-sm--50">
                <div class="col-lg-9 order-lg-2" id="main-content">
                    <div class="shop-toolbar">
                        <div class="shop-toolbar__inner">
                            <div class="row align-items-center">
                                <div class="col-md-6 text-md-left text-center mb-sm--5">

                                </div>
                                <div class="col-md-6">
                                    <div class="shop-toolbar__right">
                                        <div class="product-ordering">
                                            <a href="" class="product-ordering__btn shop-toolbar__btn">
                                                <span>按排序</span>
                                                <i></i>
                                            </a>
                                            <ul class="product-ordering__list">
                                                <li class="active"><a href="#">按人气排序</a></li>
                                                <li><a v-on:click="orderByPrice('ASC')">按价格排序：从低到高</a></li>
                                                <li><a v-on:click="orderByPrice('DESC')">按价格排序：从高到低</a></li>
                                            </ul>
                                        </div>
                                        <div class="product-view-mode">
                                            <a class="active" href="#" data-target="grid">
                                                <i class="fa fa-th"></i>
                                            </a>
                                            <a href="#" data-target="list">
                                                <i class="fa fa-list"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="shop-products">
                        <div class="row xxl-block-grid-5 grid-space-20" >
                            <div class="col-xl-3 col-lg-4 col-sm-6 ptb--10 mb--20" v-for="item in items" :key="item.id">
                                <div class="zuka-product thumb-has-effect">
                                    <div class="product-inner">
                                        <figure class="product-image">
                                            <div class="product-image--holder">
                                                <!--获取id当页面详情跳转页-->
                                                <a :href="'/item/'+item.id+'.html'" target="_blank">
                                                    <img :src="item.image" alt="Product Image" class="primary-image">
                                                    <img :src="item.image" alt="Product Image" class="secondary-image">
                                                </a>
                                            </div>
                                            <div class="zuka-product-action">
                                                <div class="product-action d-flex flex-column align-items-end">
                                                    <a class="add_wishlist action-btn" href="wishlist.html" @click.prevent="addCollect(item.id)" data-toggle="tooltip" data-placement="top" title="" data-original-title="收藏">
                                                        <i class="dl-icon-heart4"></i>
                                                    </a>
                                                    <a class="add_to_cart_btn action-btn" href="cart.html" @click.prevent="addCart(item.id)" data-toggle="tooltip" data-placement="top" title="" data-original-title="添加到购物车">
                                                        <i class="dl-icon-cart29"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </figure>
                                        <div class="product-info text-center">
                                            <div class="star-rating star-four">
                                                <span>Rated <strong class="rating">4.00</strong> out of 5</span>
                                            </div>
                                            <h3 class="product-title">
                                                <a :href="'/item/'+item.id+'.html'">{{item.title}}</a>
                                            </h3>
                                            <span class="product-price-wrapper">
                                                        <span class="money">&pound;{{item.price}}.00</span>
                                                    </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="zuka-product-list thumb-has-effect">
                                    <div class="product-inner" >
                                        <figure class="product-image">
                                            <div class="product-image--holder">
                                                <!--获取id当页面详情跳转页 http://www.leshang.com/item/45000.html-->
                                                <a :href="'/item/'+item.id+'.html'">
                                                    <img :src="item.image" alt="Product Image" class="primary-image">
                                                    <img :src="item.image" alt="Product Image" class="secondary-image">
                                                    <div class="product-overlay"></div>
                                                </a>
                                            </div>
                                            <div class="product-thumbnail-action">
                                                <a class="quickview-btn action-btn" data-toggle="tooltip" data-placement="top" title="" data-original-title="Quick Shop">
                                                            <span data-toggle="modal"  data-target="#productModal">
                                                                <i class="dl-icon-view"></i>
                                                            </span>
                                                </a>
                                            </div>

                                        </figure>
                                        <div class="product-info">
                                            <div class="star-rating star-four">
                                                <span>Rated <strong class="rating">4.00</strong> out of 5</span>
                                            </div>
                                            <h3 class="product-title mt--20 mb--20">
                                                <a href="product-details.html   ">{{item.title}}</a>
                                            </h3>
                                            <span class="product-price-wrapper mb--10">
                                                        <span class="money">&pound;{{item.price}}.00</span>
                                                    </span>
                                            <p class="product-short-description mb--20">
                                                Donec accumsan auctor iaculis. Sed suscipit arcu ligula, at egestas magna molestie a. Proin ac ex maximus, ultrices justo eget, sodales orci. Aliquam egestas libero ac turpis pharetra, in vehicula lacus scelerisque. Vestibulum ut sem laoreet, feugiat tellus at, hendrerit arcu.
                                            </p>
                                            <div class="zuka-product-action zuka-product-action-list">
                                                <div class="product-action">
                                                    <a class="add_wishlist" href="wishlist.html" data-toggle="tooltip" data-placement="top" title="" data-original-title="Add to Wishlist">
                                                        <i class="dl-icon-heart4"></i>
                                                    </a>
                                                    <a class="btn add_to_cart_btn" href="cart.html" data-toggle="tooltip" data-placement="top" title="" data-original-title="Add to Cart">
                                                        <span>Add To Cart</span>
                                                    </a>
                                                    <a class="add_compare" href="compare.html" data-toggle="tooltip" data-placement="top" title="" data-original-title="Add to Compare">
                                                        <i class="dl-icon-compare2"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <nav class="pagination-wrap">
                        <ul class="pagination">
                            <li><a href="shop-sidebar.html"  @click.prevent="prePage" class="prev page-number"><i class="fa fa-angle-double-left"></i></a></li>
                            <li v-for="i in Math.min(5,totalPage)" :key="i">
                                <span :class="index(i) === page?'current page-number':'page-number'" @click="selectPage(index(i))" v-text="index(i)"></span>
                            </li>
                            <li  v-show="page+2<totalPage && totalPage >5"><span>...</span></li>
                            <li><a href="shop-sidebar.html" @click.prevent="nextPage" class="next page-number"><i class="fa fa-angle-double-right"></i></a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3 order-lg-1 mt--25 mt-md--40" id="primary-sidebar">
                    <div class="sidebar-widget">
                        <!-- Category Widget Start -->
                        <div class="product-widget categroy-widget mb--35 mb-md--30">
                            <h3 class="widget-title">类别</h3>
                            <ul class="prouduct-categories product-widget__list">
                                <li v-for="cat in commodity" :key="cat.id" >
                                    <a v-on:click="goFind(cat.id)">{{cat.name}}</a>
                                    <span class="count">({{cat.itemNum}})</span>
                                </li>
                            </ul>
                        </div>
                        <!-- Category Widget Start -->

                        <!-- Price Filter Widget Start -->

                        <!-- Price Filter Widget End -->

                        <!-- Category Widget Start -->
                        <div class="product-widget tag-widget mb--35 mb-md--30">
                            <h3 class="widget-title">Categories</h3>
                            <div class="tagcloud">
                                <a v-on:click="goFind(cat.id)" v-for="cat in commodity" :key="cat.id">{{cat.name}}</a>
                            </div>
                        </div>
                        <!-- Category Widget Start -->

                        <!-- Promo Widget Start -->
                        <div class="product-widget promo-widget">
                            <div class="banner-box banner-type-3 banner-type-3-2 banner-hover-3">
                                <div class="banner-inner">
                                    <div class="banner-image">
                                        <img src="/assets/img/banner/shop_banner_sidebar_01.jpg" alt="Banner">
                                    </div>
                                    <div class="banner-info">
                                        <div class="banner-info--inner">
                                            <p class="banner-title-2 font-normal color--white">Man Fashion</p>
                                            <p class="banner-title-7 color--white">男士时尚</p>
                                        </div>
                                    </div>
                                    <a class="banner-link banner-overlay" href="shop-sidebar">现在去购物</a>
                                </div>
                            </div>
                        </div>
                        <!-- Promo Widget End -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
`,
    name: "commodity",   //页面
    data() {
        return {
            items: {},
            commodity: {},
            cType: 0,   //当前类别选中的类别
            ly,
            search: {},
            goodsList: [],
            total: 0,
            page: 1,
            ByType: true,//分类查或搜索查
            way: '',
            totalPage: 0,
            selectedSku: {},
            filters: [],//过滤项
        }
    },
    created() {
        //获取请求参数
        const search = ly.parse(location.search.substring(1))
        //默认页给1
        this.page = parseInt(search.page) || 1;
        this.search = search;
        if (!this.search.key) {
            this.goFind(1429)
        }else{
            this.loadData();//搜索发起请求
        }
        //查询分类
        ly.http.get("/item-service/itemCat").then(resp => {
            this.commodity = resp.data;
        })
    },
    watch:{
        search:{
            deep:true,
            handler(val,oldVal){
                this.loadData();
                //把请求参数写到url中
                if (!oldVal || !oldVal.key){
                    return;
                }
                location.search = "?"+ly.stringify(this.search)
            }
        },
        page:{  //监听当前页码值的改变，根据搜索或分类不同查询
            deep:true,
            handler(){
                if(this.ByType)
                    this.searchQuery(this.page,this.search.sort);
                else
                    this.itemPageByCid(this.page,this.cType,this.way);
            }
        }
    }
    ,
    methods: {
        loadData() {
            //发送后台
            ly.http.post("/search/page", this.search).then(resp => {
                //保存分页结果
                this.total = resp.data.total;
                this.totalPage= resp.data.totalPage;
                this.items = resp.data.items;
                console.log(this.items)
                //保存当前页商品
                this.goodsList = resp.data.items;
                //我们获取聚合结果，形参过滤项
            }).catch(error => {

            })
        },
        selectPage(i){
            this.page = i;  //修改当前页
        },
        index(i){
            if (this.page <= 3 || this.totalPage < 5 ){
                return i;
            }else if(this.page >= this.totalPage - 2){
                return this.totalPage - 5 + i;
            }else{
                return i + this.page - 3;
            }
        },
        prePage(){
            if (this.page > 1) this.page--;
        },
        nextPage(){
            if (this.page <this.totalPage) this.page++;
        },
        goFind(cid) {
            ly.http.get("/item/cid/ASC/?cid="+cid).then(resp => {
                this.ByType = false;    //修改根据分类查询
                this.cType = cid;
                this.page =1;
                this.items = resp.data.items;
                this.total = resp.data.total;
                this.totalPage= resp.data.totalPage;
            })
        },
        itemPageByCid(page,cid,way){
            this.way = way.length==0?'ASC':way;
            ly.http.get("/item/cid/"+this.way+"/?cid="+cid+"&page="+page).then(resp => {
                this.items = resp.data.items;
                this.total = resp.data.total;
                this.totalPage= resp.data.totalPage;
            })
        },
        orderByPrice(way){
            this.page = 1;//排序后初始当前页码
            if (this.cType!=0){
                this.way = way;//记录当前排序规则
                this.itemPageByCid(this.page,this.cType,way);
                return;
            }
            this.searchQuery(this.page,way);
        },
        searchQuery(page,way){
            const search = ly.parse(location.search.substring(1))
            if (search!= null) {
                //发送后台
                this.search.sort = way;
                this.search.page = page;
                ly.http.post("/search/page", this.search).then(resp => {
                    //保存分页结果
                    this.total = resp.data.total;
                    this.totalPage= resp.data.totalPage;
                    this.items = resp.data.items;
                    //保存当前页商品
                }).catch(error => {

                });
            }
        },
        addCart(id) {  //添加购物车
            // 判断是否登录
            this.item = this.items.find(i => i.id === id); //查找到该商品
            ly.verifyUser().then(() => {
                // 已登录
                ly.http.post("/cart", {
                    id: this.item.id,
                    title: this.item.title,
                    image: this.item.image,
                    price: this.item.price,
                    num:1,
                    stock:this.item.num,//商品库存
                    sellPoint:this.item.sellPoint
                }).then(() => {
                    // 跳转到购物车列表页
                    window.location.href = "http://www.leshang.com/cart.html";
                }).catch(() => {
                    alert("添加购物车失败，请重试！");
                })
            }).catch(() => {
                // 获取以前的购物车
                const carts = ly.store.get("carts") || [];
                // 获取与当前商品id一致的购物车数据
                const cart = carts.find(i => i.id === id); //查找到该商品
                if (cart) {
                    // 存在，修改数量
                    cart.num += this.num;
                } else {
                    // 不存在，新增
                    carts.push({
                        id: this.item.id,
                        title: this.item.title,
                        image: this.item.image,
                        price: this.item.price,
                        num:1,
                        stock:this.item.num,    //商品库存
                        sellPoint:this.item.sellPoint
                    })
                }
                // 未登录
                ly.store.set("carts", carts);
                // 跳转到购物车列表页
                window.location.href = "http://www.leshang.com/cart.html";
            })
        },
        addCollect(spuId){
            ly.verifyUser().then(resp => {
                ly.http.post("/user-service/collect", {
                    collectUserId:resp.data.id,
                    collectSpuId:spuId
                }).then(resp => {
                    // 跳转到收藏列表页
                    window.location.href = "http://www.leshang.com/wishlist.html";
                }).catch(resp => {
                    let rest = ly.parse(resp);
                    if (rest.response.data.status == 403){
                        alert(rest.response.data.message)
                        window.location.href = "http://www.leshang.com/wishlist.html";
                    }
                })

            }).catch(resp => {
                // 未登陆状态时，跳转至登陆页面
                window.location.href = "/login.html?returnUrl="+window.location.href;
            })
        }

    },
};
export default commodity;