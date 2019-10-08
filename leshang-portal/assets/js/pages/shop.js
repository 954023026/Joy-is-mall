const shortcut = {
    template: `<header class="header header-st yle-3" id="shortcut">
    <div class="header-inner headroom headroom--fixed">
        <div class="top-bar d-none d-lg-block">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-xl-4 d-none d-xl-block">
                        <!-- Social Icons Start Here -->
                        <ul class="social social-medium dark-color">
                            <li class="social__item">
                                <a href="https://www.facebook.com" class="social__link">
                                    <i class="fa fa-facebook"></i>
                                </a>
                            </li>
                            <li class="social__item">
                                <a href="https://www.twitter.com" class="social__link">
                                    <i class="fa fa-twitter"></i>
                                </a>
                            </li>
                            <li class="social__item">
                                <a href="https://www.pinterest.com" class="social__link">
                                    <i class="fa fa-pinterest"></i>
                                </a>
                            </li>
                            <li class="social__item">
                                <a href="https://www.youtube.com" class="social__link">
                                    <i class="fa fa-youtube"></i>
                                </a>
                            </li>
                            <li class="social__item">
                                <a href="https://www.plus.google.com" class="social__link">
                                    <i class="fa fa-google-plus"></i>
                                </a>
                            </li>
                        </ul>
                        <!-- Social Icons End Here -->
                    </div>
                    <div class="col-xl-4 text-center">
                        <div class="header__text">
                            <span>Flash sale! Off 20% All Items This Week <a
                                    href="../shop-sidebar.html">SHOP NOW</a></span>
                        </div>
                    </div>
                    <div class="col-xl-4 text-right d-none d-xl-block">
                        <div class="contact-info">
                                    <span>
                                        <i class="fa fa-phone"></i>
                                        (+612) 2531 5600
                                    </span>
                            <span>
                                        <i class="fa fa-envelope"></i>
                                        info@company.com
                                    </span>
                            <span>
                                        <i class="fa fa-map-marker"></i>
                                        Get direction
                                    </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-top">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-lg-3 col-6">
                        <!-- Logo Start Here -->
                        <a href="../index.html" class="logo-box">
                            <figure class="logo--normal">
                                <img src="../assets/img/logo/logo.png" alt="Logo"/>
                            </figure>
                        </a>
                        <!-- Logo End Here -->
                    </div>
                    <div class="col-lg-6 d-lg-block d-none">
                        <form action="shop-sidebar.html" class="searchform searchform-3">
                             <input type="text" name="key" id="search"  v-model='key'  class="searchform__input"
                                   placeholder="Search Products">
                            <button type="button" @click.prevent='search' class="searchform__submit"><i class="dl-icon-search1"></i></button>
                        </form>
                    </div>
                    <div class="col-lg-3 col-6">
                        <ul class="header-toolbar header-toolbar-3 text-right">
                            <li class="header-toolbar__item d-lg-block d-none">
                                <a href="../wishlist.html">
                                    <i class="fa fa-heart-o"></i>
                                </a>
                            </li>
                            <li class="header-toolbar__item user-info-menu-btn d-lg-block d-none">
                                <a href="">
                                    <i class="fa fa-user-circle-o"></i>
                                </a>
                                <ul class="user-info-menu">
                                    <li v-if='user && user.username'>
                                        <a href="my-account.html" v-text="user.username"></a>
                                        <a href="order-tracking.html">我的订单</a>
                                        <a href="compare.html">收藏</a>
                                        <a href="../wishlist.html">我的收藏</a>
                                        <a href="#" @click.prevent="loginOut">注销</a>
                                    </li>
                                    <li v-else>
                                        <a href="#" @click.prevent="gotoLogin">登录</a>
                                        <a href="#" @click.prevent="gotoLogin">注册</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="header-toolbar__item">
                                <a href="#miniCart" @click.prevent="ly.minCart" class="mini-cart-btn mini-cart-btn-3 toolbar-btn">
                                    <i class="dl-icon-cart25"></i>
                                    <sup class="mini-cart-count" v-if="cart.num>0" v-text="cart.num"></sup>
                                </a>
                            </li>
                            <li class="header-toolbar__item d-lg-none">
                                <a href="#searchForm" class="search-btn toolbar-btn">
                                    <i class="dl-icon-search1"></i>
                                </a>
                            </li>
                            <li class="header-toolbar__item d-lg-none">
                                <a href="#mobileMenu" class="toolbar-btn menu-btn">
                                    <span class="hamburger-icon">
                                    </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-bottom d-lg-block d-none" style="background-color: #0A9400;">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-xl-8 col-lg-7">
                        <div class="header-bottom__left">
                            <!-- Secondary Navigation Start Here -->
                            <nav class="secondary-navigation d-xl-block d-none">
                                <a href="#" class="secondary-nav-btn">
                                    <i class="fa fa-navicon"></i>
                                    按分类购物
                                </a>
                                <ul class="secondary-menu">
                                    <li><a href="">Beauty</a></li>
                                    <li><a href="">Bike</a></li>
                                    <li><a href="">Books</a></li>
                                    <li><a href="">Cell Phones &amp; Accessories</a></li>
                                    <li><a href="">Clothing</a></li>
                                    <li><a href="">Digitar Music</a></li>
                                    <li><a href="">Electronics &amp; Tech</a></li>
                                    <li><a href="">Fashions</a></li>
                                    <li><a href="">Food</a></li>
                                    <li><a href="">Furniture</a></li>
                                </ul>
                            </nav>
                            <!-- Secondary Navigation End Here -->

                            <!-- Main Navigation Start Here -->
                            <nav class="main-navigation main-navigation-3 white-color">
                                <ul class="mainmenu">
                                    <li class="mainmenu__item menu-item-has-children megamenu-holder active">
                                        <a href="../index.html" class="mainmenu__link">
                                            <span class="mm-text">主页</span>
                                        </a>
                                    </li>
                                    <li class="mainmenu__item menu-item-has-children megamenu-holder">
                                        <a href="shop-sidebar.html" class="mainmenu__link">
                                            <span class="mm-text">商城</span>
                                            <span class="badge">热门</span>
                                        </a>
                                    </li>
                                    <li class="mainmenu__item">
                                        <a href="shop-collections.html" class="mainmenu__link">
                                            <span class="mm-text">Collections</span>
                                        </a>
                                    </li>
                                    <li class="mainmenu__item menu-item-has-children has-children">
                                        <a href="blog.html" class="mainmenu__link">
                                            <span class="mm-text">Blog</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <li class="menu-item-has-children has-children">
                                                <a href="#">
                                                    <span class="mm-text">Blog Grid</span>
                                                </a>
                                                <ul class="sub-menu">
                                                    <li>
                                                        <a href="blog-02-columns.html">
                                                            <span class="mm-text">Blog 02 Columns</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="blog-03-columns.html">
                                                            <span class="mm-text">Blog 03 Columns</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="blog.html">
                                                            <span class="mm-text">Blog Sidebar</span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="menu-item-has-children has-children">
                                                <a href="#">
                                                    <span class="mm-text">Blog List</span>
                                                </a>
                                                <ul class="sub-menu">
                                                    <li>
                                                        <a href="blog-classic.html">
                                                            <span class="mm-text">Blog Classic</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="blog-no-sidebar.html">
                                                            <span class="mm-text">Blog No Sidebar</span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li>
                                                <a href="blog-masonary.html">
                                                    <span class="mm-text">Blog Masonary</span>
                                                </a>
                                            </li>
                                            <li class="menu-item-has-children has-children">
                                                <a href="#">
                                                    <span class="mm-text">Blog Details</span>
                                                </a>
                                                <ul class="sub-menu">
                                                    <li>
                                                        <a href="single-post.html">
                                                            <span class="mm-text">Single Post</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="single-post-sidebar.html">
                                                            <span class="mm-text">Single Post Sidebar</span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="mainmenu__item">
                                        <a href="shop-instagram.html" class="mainmenu__link">
                                            <span class="mm-text">New Look</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                            <!-- Main Navigation End Here -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
`,
    name: "shortcut",   //页面头部
    data() {
        return {
            user: {},
            msg: '',
            key: "",
            query: location.search,
            ly,
            cart
        }

    },
    created() {
        ly.http("/auth/verify").then(resp => {
                this.user = resp.data;
            })
    },
    methods: {
        gotoLogin() {
            window.location = "login.html?returnUrl=" + window.location;
        },
        search() {
            window.location = 'shop-sidebar.html?key=' + this.key;
        },
        loginOut(){
            ly.verifyUser().then(resp => {
                ly.http.delete("/auth/loginOut")
                    .then(resp => {
                        window.location = "index.html";
                    })
            })
        }

    }
};
export default shortcut;