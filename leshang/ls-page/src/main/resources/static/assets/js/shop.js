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
                        <form action="#" class="searchform searchform-3">
                            <input type="text" name="search" id="search" class="searchform__input"
                                   placeholder="Search Products">
                            <button type="submit" class="searchform__submit"><i class="dl-icon-search1"></i></button>
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
                                        <a href="my-account.html">{{user.username}}</a>
                                        <a href="order-tracking.html">我的订单</a>
                                        <a href="compare.html">收藏</a>
                                        <a href="../wishlist.html">我的收藏</a>
                                        <a href="lost-password.html">注销</a>
                                    </li>
                                    <li v-else>
                                        <a href="my-account.html">登录</a>
                                        <a href="my-account1.html">注册</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="header-toolbar__item">
                                <a href="#miniCart" class="mini-cart-btn mini-cart-btn-3 toolbar-btn">
                                    <i class="dl-icon-cart25"></i>
                                    <sup class="mini-cart-count">2</sup>
                                </a>
                            </li>
                            <!--<li class="header-toolbar__item d-none d-lg-block">
                                <a href="#sideNav" class="toolbar-btn">
                                            <span class="hamburger-icon">
                                            </span>
                                </a>
                            </li>-->
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
                                    SHOP BY DEPARTMENT
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
                                        <ul class="megamenu four-column">
                                            <li>
                                                <a class="megamenu-title" href="#">
                                                    <span class="mm-text">Shop Layout</span>
                                                </a>
                                                <ul>
                                                    <li>
                                                        <a href="shop-fullwidth.html">
                                                            <span class="mm-text">FullWidth</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="../shop-sidebar.html">
                                                            <span class="mm-text">with Sidebar</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="shop-two-columns.html">
                                                            <span class="mm-text">Two columns</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="shop-three-columns.html">
                                                            <span class="mm-text">Three columns</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="shop-collections.html">
                                                            <span class="mm-text">With collections</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="shop-instagram.html">
                                                            <span class="mm-text">Shop Instagram</span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li>
                                                <a class="megamenu-title" href="#">
                                                    <span class="mm-text">Single Product</span>
                                                </a>
                                                <ul>
                                                    <li>
                                                        <a href="../product-details.html">
                                                            <span class="mm-text">Simple 01</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="product-details-02.html">
                                                            <span class="mm-text">Simple 02</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="product-details-sticky.html">
                                                            <span class="mm-text">Sticky Info</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="product-details-gallery.html">
                                                            <span class="mm-text">Thumbnail Gallery</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="product-details-sidebar.html">
                                                            <span class="mm-text">Sidebar</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="product-details-grouped.html">
                                                            <span class="mm-text">Grouped</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="product-details-affiliate.html">
                                                            <span class="mm-text">Affiliate</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="product-details-configurable.html">
                                                            <span class="mm-text">Configurable</span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li>
                                                <a class="megamenu-title" href="#">
                                                    <span class="mm-text">Shop Pages</span>
                                                </a>
                                                <ul class="sub-menu">
                                                    <li>
                                                        <a href="my-account.html">
                                                            <span class="mm-text">My Account</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="cart.html">
                                                            <span class="mm-text">Shopping Cart</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="checkout.html">
                                                            <span class="mm-text">Check Out</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="../wishlist.html">
                                                            <span class="mm-text">Wishlist</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="order-tracking.html">
                                                            <span class="mm-text">Order tracking</span>
                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="compare.html">
                                                            <span class="mm-text">compare</span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="banner-holder">
                                                <div class="megamenu-banner">
                                                    <div class="megamenu-banner-image"></div>
                                                    <div class="megamenu-banner-info">
                                                        <span>Autumn Winter 2019</span>
                                                        <h3>new <strong>arrival</strong></h3>
                                                    </div>
                                                    <a href="../shop-sidebar.html" class="megamenu-banner-link"></a>
                                                </div>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="mainmenu__item menu-item-has-children has-children">
                                        <a href="#" class="mainmenu__link">
                                            <span class="mm-text">Pages</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <li>
                                                <a href="about-us.html">
                                                    <span class="mm-text">About Us</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="team.html">
                                                    <span class="mm-text">Our teams</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="contact-us.html">
                                                    <span class="mm-text">Contact Page</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="404.html">
                                                    <span class="mm-text">404 page</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="faqs-page.html">
                                                    <span class="mm-text">FAQs page</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="coming-soon.html">
                                                    <span class="mm-text">Coming Soon</span>
                                                </a>
                                            </li>
                                        </ul>
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
    <div class="mobile-menu-wrapper" id="mobileMenu">
        <div class="mobile-menu-inner">
            <a href="" class="btn-close">
                        <span class="hamburger-icon">
                        </span>
            </a>
            <nav class="mobile-navigation">
                <ul class="mobile-menu">
                    <li class="menu-item-has-children active">
                        <a href="../index.html">
                            <span class="mm-text">Home</span>
                        </a>
                        <ul class="sub-menu">
                            <li class="menu-item-has-children">
                                <a href="#">
                                    <span class="mm-text">Demo Group 01</span>
                                </a>
                                <ul class="sub-menu">
                                    <li>
                                        <a href="../index.html">
                                            <span class="mm-text">Demo 01</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="index-02.html">
                                            <span class="mm-text">Demo 02</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="index-03.html">
                                            <span class="mm-text">Demo 03</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="index-04.html">
                                            <span class="mm-text">Demo 04</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="index-05.html">
                                            <span class="mm-text">Demo 05</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="#">
                                    <span class="mm-text">Demo Group 02</span>
                                </a>
                                <ul class="sub-menu">
                                    <li>
                                        <a href="index-06.html">
                                            <span class="mm-text">Demo 06</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="index-07.html">
                                            <span class="mm-text">Demo 07</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="index-08.html">
                                            <span class="mm-text">Demo 08</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="index-09.html">
                                            <span class="mm-text">Demo 09</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="index-10.html">
                                            <span class="mm-text">Demo 10</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children">
                        <a href="../shop-sidebar.html">
                            <span class="mm-text">Shop</span>
                            <span class="badge">Hot</span>
                        </a>
                        <ul class="sub-menu">
                            <li class="menu-item-has-children">
                                <a href="#">
                                    <span class="mm-text">Shop Layout</span>
                                </a>
                                <ul class="sub-menu">
                                    <li>
                                        <a href="shop-fullwidth.html">
                                            <span class="mm-text">FullWidth</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../shop-sidebar.html">
                                            <span class="mm-text">with Sidebar</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="shop-two-columns.html">
                                            <span class="mm-text">Two columns</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="shop-three-columns.html">
                                            <span class="mm-text">Three columns</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="shop-collections.html">
                                            <span class="mm-text">With collections</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="shop-instagram.html">
                                            <span class="mm-text">Shop Instagram</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="#">
                                    <span class="mm-text">Single Product</span>
                                </a>
                                <ul class="sub-menu">
                                    <li>
                                        <a href="../product-details.html">
                                            <span class="mm-text">Simple 01</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="product-details-02.html">
                                            <span class="mm-text">Simple 02</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="product-details-sticky.html">
                                            <span class="mm-text">Sticky Info</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="product-details-gallery.html">
                                            <span class="mm-text">Thumbnail Gallery</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="product-details-sidebar.html">
                                            <span class="mm-text">Sidebar</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="product-details-grouped.html">
                                            <span class="mm-text">Grouped</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="product-details-affiliate.html">
                                            <span class="mm-text">Affiliate</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="product-details-configurable.html">
                                            <span class="mm-text">Configurable</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="#">
                                    <span class="mm-text">Shop Pages</span>
                                </a>
                                <ul class="sub-menu">
                                    <li>
                                        <a href="my-account.html">
                                            <span class="mm-text">My Account</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="cart.html">
                                            <span class="mm-text">Shopping Cart</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="checkout.html">
                                            <span class="mm-text">Check Out</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../wishlist.html">
                                            <span class="mm-text">Wishlist</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="order-tracking.html">
                                            <span class="mm-text">Order tracking</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="compare.html">
                                            <span class="mm-text">compare</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children">
                        <a href="#">
                            <span class="mm-text">Pages</span>
                        </a>
                        <ul class="sub-menu">
                            <li>
                                <a href="about-us.html">
                                    <span class="mm-text">About Us</span>
                                </a>
                            </li>
                            <li>
                                <a href="team.html">
                                    <span class="mm-text">Our teams</span>
                                </a>
                            </li>
                            <li>
                                <a href="contact-us.html">
                                    <span class="mm-text">Contact Page</span>
                                </a>
                            </li>
                            <li>
                                <a href="404.html">
                                    <span class="mm-text">404 page</span>
                                </a>
                            </li>
                            <li>
                                <a href="faqs-page.html">
                                    <span class="mm-text">FAQs page</span>
                                </a>
                            </li>
                            <li>
                                <a href="coming-soon.html">
                                    <span class="mm-text">Coming Soon</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="mobile-menu__item">
                        <a href="shop-collections.html">
                            <span class="mm-text">Collections</span>
                        </a>
                    </li>
                    <li class="menu-item-has-children">
                        <a href="blog.html">
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
                    <li>
                        <a href="shop-instagram.html">
                            <span class="mm-text">New Look</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>`,
    name: "shortcut",   //页面头部
    data() {
        return {
            user: null,
            form:{
                username:'zhou',
                password:'123456'
            },
            msg:''
        }

    },
    created() {
        ly.http.post("/auth/login", ly.stringify(this.form));

        ly.http("/auth/verify")
            .then(resp => {
                this.user = resp.data;
            })
    },
    methods: {
        gotoLogin() {
            window.location = "login.html?returnUrl=" + window.location;
        }
    }
};
export default shortcut;