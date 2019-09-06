(function($){

	'use strict';
    //最新最全最好的Bootstrap模板：http://www.bootstrapmb.com
    // Check if element exists
    $.fn.elExists = function() {
        return this.length > 0;
    };

	// Variables

	var $html = $('html'),
		$body = $('body'),
		$window = $(window),
		$bgcolor = $('.bg-color'),
		$bgimage = $('.bg-image'),
		$header = $('.header'),
		$fixedHeader = $('.headroom--fixed'),
		$overlay = $('.zuka-global-overlay'),
		$window_width = $(window).outerWidth(),
		$pageUrl = window.location.href.substr(window.location.href.lastIndexOf("/") + 1),
		$headerPosition = ( $header.elExists() ) ? $header.offset().top : '',
		$mainHeaderHeight = ( $header.elExists() ) ? $header[0].getBoundingClientRect().height : 0,
		$headerTotalHeaight = $headerPosition + $mainHeaderHeight,
		$elementCarousel = $('.zuka-element-carousel'),
		$instafeed = $('.zuka-insta-feed');



	/**********************
	*Background Color settings
	***********************/ 

	$bgcolor.each(function(){
		var $this = $(this),
			$color = $this.data('bg-color');

		$this.css('background-color', $color);
	});

	/**********************
	*Background Image settings
	***********************/ 

	$bgimage.each(function(){
		var $this = $(this),
			$image = $this.data('bg-image');

		$this.css({
			'background-image': 'url(' + $image + ')'
		});
	});


	
	/**********************
	*Mobile Menu
	***********************/ 
    
    /*Variables*/
    var $mobileNav = $('.mobile-menu'),
        $mobileNavSubMenu = $mobileNav.find('.sub-menu');
    
    /*Add Toggle Button With Off Canvas Sub Menu*/
    $mobileNavSubMenu.parent().prepend('<span class="menu-expand"><i class="fa fa-angle-down"></i></span>');
    
    /*Close Off Canvas Sub Menu*/
    $mobileNavSubMenu.slideUp();
    
    /*Category Sub Menu Toggle*/
    $mobileNav.on('click', 'li a, li .menu-expand', function(e) {
        var $this = $(this);
        if ( ($this.parent().attr('class').match(/\b(menu-item-has-children|has-children|has-sub-menu)\b/)) && ($this.attr('href') === '#' || $this.hasClass('menu-expand')) ) {
            e.preventDefault();
            if ($this.siblings('ul:visible').length){
                $this.siblings('ul').slideUp('slow');
            }else {
                $this.closest('li').siblings('li').find('ul:visible').slideUp('slow');
                $this.siblings('ul').slideDown('slow');
            }
        }
        if( $this.is('a') || $this.is('span') || $this.attr('clas').match(/\b(menu-expand)\b/) ){
        	$this.parent().toggleClass('menu-open');
        }else if( $this.is('li') && $this.attr('class').match(/\b('menu-item-has-children')\b/) ){
        	$this.toggleClass('menu-open');
        }
    });
    
	/**********************
	* Newsletter Popup
	***********************/

	$(window).on('load', function(){
		setTimeout(function(){
			$('.zuka-newsletter-popup').addClass('open');
		},5000);
	});


	/**********************
	* Countdown Activation
	***********************/
	
	$('[data-countdown]').each(function() {
		var $this = $(this), finalDate = $(this).data('countdown');
		$this.countdown(finalDate, function(event) {
			$this.html(event.strftime('<div class="single-countdown"><span class="single-countdown__time">%D</span><span class="single-countdown__text">Days</span></div><div class="single-countdown"><span class="single-countdown__time">%H</span><span class="single-countdown__text">Hrs</span></div><div class="single-countdown"><span class="single-countdown__time">%M</span><span class="single-countdown__text">mins</span></div><div class="single-countdown"><span class="single-countdown__time">%S</span><span class="single-countdown__text">Secs</span></div>'));
		});
	}); 

	/**********************
	*Header Toolbar Sidenav Expand
	***********************/

	$('.toolbar-btn').on('click', function(e){
		e.preventDefault();
		e.stopPropagation();
		var $this = $(this);
		var target = $this.attr('href');
		var prevTarget = $('.toolbar-btn').attr('href');
		var prevTarget = $this.parent().siblings().children('.toolbar-btn').attr('href');
		$(target).toggleClass('open');
		$(prevTarget).removeClass('open');
		if(!$this.attr('class').match(/\b(menu-btn|search-btn)\b/)){
			$overlay.addClass('overlay-open');
		}
		if($this.attr('class').match(/\b(menu-btn)\b/)){
			$this.toggleClass('open');
		}
	});

	

	/**********************
	*Click on Documnet
	***********************/

	$body.on('click', function (e){
	    var $target = e.target;
	    var dom = $('.wrapper').children();
	    
	    if (!$($target).is('.toolbar-btn') && !$($target).is('.product-filter-btn') && !$($target).parents().is('.open')) {
	        dom.removeClass('open');
	        dom.find('.open').removeClass('open');
	        $overlay.removeClass('overlay-open');
	    }
	});


	/**********************
	*Close Button Actions
	***********************/

	$('.btn-close').on('click', function(e){
		e.preventDefault();
		var $this = $(this);
		$this.parents('.open').removeClass('open');
		if($overlay.hasClass('overlay-open')){
			$overlay.removeClass('overlay-open');
		}
		if($this.parents().attr('class').match('mobile-menu-wrapper')){
			$('.menu-btn').removeClass('open');
		}
	});

	/**********************
	*Sticky Header
	***********************/	

	if($fixedHeader.elExists()){
		var myElement = document.querySelector(".headroom--fixed");
		var headroom  = new Headroom(myElement);
		// initialise
		headroom.init(); 

		$(window).on('scroll', function(){
			if($(window).scrollTop() <= 0){
				$(".headroom--fixed").removeClass('headroom--pinned is-sticky');
			}
			if($(window).scrollTop() > $headerTotalHeaight){
				$(".headroom--fixed").addClass('is-sticky');
			}
		});
	}

	/**********************
	*Sticky Social
	***********************/

	function stickySocial(stickyArg){
		if($(stickyArg.selector).elExists()){
			var sticky = $(stickyArg.selector);
			var container = $(stickyArg.container);
			var topPosition = sticky.offset().top;
			var leftPosition = sticky.offset().left;
			var height = sticky.outerHeight();
			var containerHeight = container.outerHeight();
			var containerTop = container.offset().top;
			var stickyPosition =  topPosition - height;
			var topSpacing = stickyArg.topSpacing;
			var defaultTopSpacing = topPosition - containerTop;
			var columnWidth = parseInt(stickyArg.columnWidth, 10);
			var className = stickyArg.selector.substr(1);
			console.log(sticky.offset());

			$(window).on('scroll', function(){
				var windowTop = $(window).scrollTop(); 
				if(windowTop >= stickyPosition && windowTop <= containerHeight){
					sticky.addClass('fixed').css({'position': 'fixed', 'width': '50px', 'top': topSpacing});
				} else{
					sticky.removeClass('fixed').css({'position': 'absolute', 'bottom': '0'});
				}
			});

			$(window).on({
				load: function(){
					
					if($window_width < columnWidth){
						sticky.removeClass(className).addClass('no-sticky');
					}else{
						sticky.addClass(className).removeClass('no-sticky');
					}
				},
				resize: function(){
					var ww = $(window).outerWidth();
					if(ww < columnWidth){
						sticky.removeClass(className).addClass('no-sticky');
					}else{
						sticky.addClass(className).removeClass('no-sticky');
					}
				}
			});
		}

	}
	var SocialStickyArg = {
		"selector": ".sticky-social",
		"container": ".single-post",
		"topSpacing": "30px",
		"columnWidth": "991"
	}

	stickySocial(SocialStickyArg);


	/**********************
	*Adding Slide effect to dropdown
	***********************/ 

	$('.dropdown').on('show.bs.dropdown', function(e){
	  $(this).find('.dropdown-menu').first().stop(true, true).slideDown(300);
	});

	$('.dropdown').on('hide.bs.dropdown', function(e){
	  $(this).find('.dropdown-menu').first().stop(true, true).slideUp(200);
	});	


	/**********************
	*BootStrap Tab
	***********************/ 

	$('.product-tab__link').on('click', function(){
		var parent = $(this).parent('.product-tab__item');
		parent.addClass('active');
		parent.siblings().removeClass('active');
	});



	/**********************
	* Product Quantity
	***********************/

    $(".quantity").append('<div class="dec qtybutton">-</div><div class="inc qtybutton">+</div>');

    $(".qtybutton").on("click", function () {
        var $button = $(this);
        var oldValue = $button.parent().find("input").val();
        if ($button.hasClass("inc")) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 1;
            }
        }
        $button.parent().find("input").val(newVal);
    });	


	/**********************
	* Expand User Activation
	***********************/

	$(".expand-btn").on('click', function(e){
		e.preventDefault();
		var target = $(this).attr('href');
		$(target).slideToggle('slow');
	});

	/**********************
	*Expand new shipping info  
	***********************/

	$("#shipdifferetads").on('change', function(){
		if(  $("#shipdifferetads").prop( "checked" ) ){
			$(".ship-box-info").slideToggle('slow');
		}else{
			$(".ship-box-info").slideToggle('slow');
		}
	});


	/**********************
	* Expand payment Info
	***********************/

    $('input[name="payment-method"]').on('click', function () {
        var $value = $(this).attr('value');
        $(this).parents('.payment-group').siblings('.payment-group').children('.payment-info').slideUp('300');
        $('[data-method="' + $value + '"]').slideToggle('300');
    });

	/**********************
	* Popup Close
	***********************/

	$('.popup-close').on('click', function(e){
		e.preventDefault();
		$('#subscribe-popup').fadeOut('slow');
	});
	$('.subscribe-btn').on('click', function(e){
		$('#subscribe-popup').fadeOut('slow');
	});
	$('.zuka-newsletter-popup-modal').on('click', function(e){
		e.stopPropagation();
	});

	/**********************
	* Product Filter Expand
	***********************/

	$('.product-filter-btn').on('click', function(e){
		e.preventDefault();
		e.stopPropagation();
		$(this).toggleClass('open');
		$('.advanced-product-filters').slideToggle('slow');
	});
	
	/**********************
	*Element Carousel
	***********************/ 

	function zukaElementCarousel() {
		if($elementCarousel.elExists()){
			var slickInstances = [];

			$elementCarousel.each(function(index, element){
				var $this = $(this);	

				// Carousel Options
				

				var $options = typeof $this.data('slick-options') !== 'undefined' ? $this.data('slick-options') : ''; 

				var $spaceBetween = $options.spaceBetween ? parseInt($options.spaceBetween) : 0,
				    $spaceBetween_xl = $options.spaceBetween_xl ? parseInt($options.spaceBetween_xl) : 0,
				    $rowSpace = $options.rowSpace ? parseInt($options.rowSpace) : 0,
				    $isCustomArrow = $options.isCustomArrow ? $options.isCustomArrow : false,
				    $customPrev = $isCustomArrow === true ? ($options.customPrev ? $options.customPrev : '') : '',
				    $customNext = $isCustomArrow === true ? ($options.customNext ? $options.customNext : '') : '',
				    $vertical = $options.vertical ? $options.vertical : false,
				    $focusOnSelect = $options.focusOnSelect ? $options.focusOnSelect : false,
				    $asNavFor = $options.asNavFor ? $options.asNavFor : '',
				    $fade = $options.fade ? $options.fade : false,
				    $autoplay = $options.autoplay ? $options.autoplay : false,
				    $autoplaySpeed = $options.autoplaySpeed ? $options.autoplaySpeed : 5000,
				    $swipe = $options.swipe ? $options.swipe : false,
				    $verticalSwiping = $options.verticalSwiping ? $options.verticalSwiping : false,
				    $arrows = $options.arrows ? $options.arrows : false,
				    $dots = $options.dots ? $options.dots : false,
				    $adaptiveHeight = $options.adaptiveHeight ? $options.adaptiveHeight : false,
				    $infinite = $options.infinite ? $options.infinite : false,
				    $centerMode = $options.centerMode ? $options.centerMode : false,
				    $centerPadding = $options.centerPadding ? $options.centerPadding : '',
				    $speed = $options.speed ? parseInt($options.speed) : 1000,
				    $prevArrow = $arrows === true ? ($options.prevArrow ? '<span class="'+ $options.prevArrow.buttonClass +'"><i class="'+ $options.prevArrow.iconClass +'"></i></span>' : '<button class="slick-prev">previous</span>') : '',
	        		$nextArrow = $arrows === true ? ($options.nextArrow ? '<span class="'+ $options.nextArrow.buttonClass +'"><i class="'+ $options.nextArrow.iconClass +'"></i></span>' : '<button class="slick-next">next</span>') : '',
				    $rows = $options.rows ? parseInt($options.rows, 10) : 1,
				    $slidesToShow = $options.slidesToShow ? parseInt($options.slidesToShow, 10) : 1,
				    $slidesToScroll = $options.slidesToScroll ? parseInt($options.slidesToScroll, 10) : 1;

				/*Responsive Variable, Array & Loops*/
				var $responsiveSetting = typeof $this.data('slick-responsive') !== 'undefined' ? $this.data('slick-responsive') : '',
				    $responsiveSettingLength = $responsiveSetting.length,
				    $responsiveArray = [];
				    for (var i = 0; i < $responsiveSettingLength; i++) {
						$responsiveArray[i] = $responsiveSetting[i];
						
					}

				// Adding Class to instances
				$this.addClass('slick-carousel-'+index);		
				$this.parent().find('.slick-dots').addClass('dots-'+index);		
				$this.parent().find('.slick-btn').addClass('btn-'+index);

				if($spaceBetween != 0){
					$this.addClass('slick-gutter-'+$spaceBetween);
				}
				if($spaceBetween_xl != 0){
					$this.addClass('slick-gutter-xl-'+$spaceBetween_xl);
				}
				var $slideCount = null;
				$this.on('init', function(event, slick){
					$slideCount = slick.slideCount;
					if($slideCount <= $slidesToShow){
						$this.children('.slick-dots').hide();	
					}
				});

				$this.slick({
					slidesToShow: $slidesToShow,
					slidesToScroll: $slidesToScroll,
					asNavFor: $asNavFor,
					autoplay: $autoplay,
					autoplaySpeed: $autoplaySpeed,
					speed: $speed,
					infinite: $infinite,
					arrows: $arrows,
					dots: $dots,
					vertical: $vertical,
					focusOnSelect: $focusOnSelect,
					centerMode: $centerMode,
					centerPadding: $centerPadding,
					swipe: $swipe,
					verticalSwiping: $verticalSwiping,
					fade: $fade,
					adaptiveHeight: $adaptiveHeight,
					prevArrow: $prevArrow,
					nextArrow: $nextArrow,
					responsive: $responsiveArray,
				});	




				if($isCustomArrow === true){
					$($customPrev).on('click', function(){
						$this.slick('slickPrev');
					});
					$($customNext).on('click', function(){
						$this.slick('slickNext');
					});
				}
			});

			// Updating the sliders in tab
			$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			    $elementCarousel.slick('setPosition');
			});
		}
	}
	$(document).ready(function(){
		zukaElementCarousel();
	});



	/*=====================================
	Instagram Feed JS
	======================================*/

	function zukaInstafeed(){
		if($instafeed.elExists()){
			$instafeed.each(function(index, element){
				var $this = $(this);
				var $settings = $this.data('insta-config');
				var activeId = $this.attr('id');
				if(activeId.length){
					var userID = $this.data('userid'),
					    accessTokenID = $this.data('accesstoken'),
					    get = $settings.get ? $settings.get : '',
					    template = $settings.template ? $settings.template : '',
					    sortBy = $settings.sortBy ? $settings.sortBy : '',
					    resolution = $settings.resolution ? $settings.resolution : '',
					    limit = $settings.limit ? $settings.limit : '',
					    links = $settings.links ? $settings.links : false;

					var userFeed = new Instafeed({
						get: get,
						userId: userID,
						accessToken: accessTokenID,
						resolution: resolution,
						template: template,
						sortBy: sortBy,
						limit: limit,
						links: links,
			            success: function () {    
			                instaFeedCarousel();
			            }
					});
					userFeed.run();
				}
			});		
		}
	}

	/*=====================================
	Instagram Feed Carousel JS
	======================================*/

	function instaFeedCarousel(){
		var instagramFeed = $(".instagram-carousel");
		instagramFeed.imagesLoaded(function () {
			instagramFeed.slick({
			slidesToShow: 5,
			slidesToScroll: 1,
			dots: false,
			arrows: false,
			responsive: [
				{
					breakpoint: 1199,
					settings: {
						slidesToShow: 3
					}
				},
				{
					breakpoint: 991,
					settings: {
						slidesToShow: 3
					}
				},
				{
					breakpoint: 767,
					settings: {
						slidesToShow: 2
					}
				},
				{
					breakpoint: 480,
					settings: {
						slidesToShow: 1
					}
				}
			]
			})
		});		
	}	
	
	$(window).on('load', function(){
		zukaInstafeed();
	});

	


	/**********************
	*Magnific Popup Activation
	***********************/ 

	var imagePopup = $('.popup-btn');
	var videoPopup = $('.video-popup');

	imagePopup.magnificPopup({
		type: 'image',
		gallery: {
			enabled: true
		}
	});

	videoPopup.magnificPopup({
		type: 'iframe',
        closeMarkup: '<button type="button" class="custom-close mfp-close"><i class="dl-icon-close mfp-close"></i></button type="button">'
	});


	/**********************
	* Nice Select Activation
	***********************/

	$('.nice-select').niceSelect();


	$('.product-view-mode a').on('click', function(e){
	    e.preventDefault();
	    
	    var shopProductWrap = $('.shop-products');
	    var viewMode = $(this).data('target');
	    
	    $('.product-view-mode a').removeClass('active');
	    $(this).addClass('active');
	    shopProductWrap.removeClass('grid list').addClass(viewMode);
	})


	// Button LightGallery JS
    var productThumb = $(".product-gallery__image img"),
        imageSrcLength = productThumb.length,
        images = [],
        indexNumbArray = [];

    for (var i = 0; i < productThumb.length; i++) {
        images[i] = {"src": productThumb[i].src};
    }
    $('.btn-zoom-popup').on('click', function (e) {
        $(this).lightGallery({
            thumbnail: false,
            dynamic: true,
            autoplayControls: false,
            download: false,
            actualSize: false,
            share: false,
            hash: true,
            index: 0,
            dynamicEl: images
        });
    });
    
	/**********************
	*Star Rating
	***********************/
	$('.stars a').on('click', function(e){
		e.preventDefault();
		$(this).addClass('active');
		$(this).siblings().removeClass('active');
	})


	/**********************
	*Tooltip
	***********************/

	$('[data-toggle="tooltip"]').tooltip();



	/* Masonary */
	
	$(window).on('load', function(){
		var $masonry = $('.masonary-blog-layout');
		var $grid = $('.blog-item');
		$grid.hide();

		$masonry.imagesLoaded({
			background: true
		}, function () {
			$grid.fadeIn();
			$masonry.masonry({
				itemSelector: '.grid-item',
				columnWidth: '.grid-sizer',
				percentPosition: true
			});
		});
	});
	

	/**********************
	*Price Slider
	***********************/
	$( "#slider-range" ).slider({
		range: true,
		min: 0,
		max: 120,
		values: [ 0, 120 ],
		slide: function( event, ui ) {
			$("#amount").val("$" + ui.values[0] + "  $" + ui.values[1]);
		}
	});
    $("#amount").val("$" + $("#slider-range").slider("values", 0) + " - " +
        "$" + $("#slider-range").slider("values", 1));


    $('.zoom').zoom();


	/**********************
	*Sticky Sidebar
	***********************/

    $('#sticky-sidebar').theiaStickySidebar({
      // Settings
      additionalMarginTop: 80
    });


	/**********************
	*Product Variation Button
	***********************/

    $('.variation-btn').on('click', function(e){
    	e.preventDefault();
    	var $attr = $(this).data('original-title');
    	$(this).parents('.variation-wrapper').siblings().children().text($attr).css('opacity', '1');
    	$('.reset_variations').css('display', 'block');
    });

    $('.reset_variations').on('click', function(e){
    	e.preventDefault();
    	$('.swatch-label strong').text('');
    	$(this).css('display', 'none');
    });

	/*================================
	    Accordion 
	==================================*/

	$('.accordion__link').on('click', function(e){
		e.preventDefault();
		var $this = $(this);
		var $target =  $(this).data('target');

		$this.parent().toggleClass('open');
		$($target).slideToggle(300);
	});

	/*================================
	    Ajax Contact Form
	==================================*/

	// Get the form.
	var form = $('#contact-form');

	// Get the messages div.
	var formMessages = $('.form__output');

	// Set up an event listener for the contact form.
	$(form).submit(function(e) {
		// Stop the browser from submitting the form.
		e.preventDefault();

		// Serialize the form data.
		var formData = $(this).serialize();
		// Submit the form using AJAX.
		$.ajax({
			type: 'POST',
			url: $(form).attr('action'),
			data: formData
		})
		.done(function(response) {
			// Make sure that the formMessages div has the 'success' class.
			$(formMessages).removeClass('error');
			$(formMessages).addClass('success');

			// Set the message text.
			$(formMessages).text(response);

			// Clear the form.
			$('#contact-form input,#contact-form textarea').val('');
		})
		.fail(function(data) {
			// Make sure that the formMessages div has the 'error' class.
			$(formMessages).removeClass('success');
			$(formMessages).addClass('error');

			// Set the message text.
			if (data.responseText !== '') {
				$(formMessages).text(data.responseText);
			} else {
				$(formMessages).text('Oops! An error occured and your message could not be sent.');
			}
		});
	});


	/*================================
	    Newsletter Form JS
	==================================*/
    var subscribeUrl = $(".mc-form").attr('action');

    $('.mc-form').ajaxChimp({
        language: 'en',
        url: subscribeUrl,
        callback: mailChimpResponse
    });

    function mailChimpResponse(resp) {
        if (resp.result === 'success') {
            $('.mailchimp-success').html('' + resp.msg).fadeIn(900);
            $('.mailchimp-error').fadeOut(400);
            $(".mc-form").trigger('reset');
        } else if (resp.result === 'error') {
            $('.mailchimp-error').html('' + resp.msg).fadeIn(900);
        }
    }

	/**********************
	*Preloader 
	***********************/

	$(window).on('load', function(){
		$('.zuka-preloader').removeClass("active");
	});

})(jQuery);


