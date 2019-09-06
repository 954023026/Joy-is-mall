(function(){

	// Home 01
	$("#rev_slider_1_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"auto",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"off",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"off",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				},
				right: {
					h_align:"right",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"larev-dot2",
				hide_onleave:false,
				direction:"horizontal",
                    container:"layergrid",
				h_align:"left",
				v_align:"bottom",
				h_offset:0,
				v_offset:90,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span><span class="tp-bullet-wrap"></span>'
			}
		},
		responsiveLevels:[1240,1240,778,480],
		visibilityLevels:[1240,1240,778,480],
		gridwidth:[1760,1760,778,480],
		gridheight:[820,820,600,500],
		lazyType:"all",
		parallax: {
			type:"mouse+scroll",
			origo:"enterpoint",
			speed:400,
          speedbg:0,
          speedls:0,
			levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		disableProgressBar:"on",
		hideThumbsOnMobile:"off",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:601,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:false,
		panZoomDisableOnMobile:"on",
		}
	});

	// Home 02
	$("#rev_slider_2_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"fullscreen",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"on",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"on",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			touch:{
				touchenabled:"on",
				touchOnDesktop:"on",
				swipe_threshold: 75,
				swipe_min_touches: 1,
				swipe_direction: "horizontal",
				drag_block_vertical: false
			}
			,
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"center",
					h_offset:40,
                    v_offset:0
				},
				right: {
					h_align:"right",
					v_align:"center",
					h_offset:40,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"ares",
				hide_onleave:false,
				direction:"vertical",
				h_align:"right",
				v_align:"center",
				h_offset:80,
				v_offset:0,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span>'
			}
		},
		responsiveLevels:[1200,1200,750,575],
		visibilityLevels:[1200,1200,750,575],
		gridwidth:[1920,1920,778,480],
		gridheight:[1000,1000,960,720],
		lazyType:"smart",
		parallax: {
			type:"mouse",
			origo:"slidercenter",
			speed:2000,
          speedbg:0,
          speedls:0,
			levels:[2,3,4,5,6,7,12,16,10,50,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		fullScreenAutoWidth:"off",
		fullScreenAlignForce:"off",
		fullScreenOffsetContainer: "#wpadminbar",
		fullScreenOffset: "",
		disableProgressBar:"on",
		hideThumbsOnMobile:"on",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:0,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:true,
		}
	});


	// Home 03

	$("#rev_slider_3_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"auto",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"off",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"off",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				},
				right: {
					h_align:"right",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"larev-dot2",
				hide_onleave:false,
				direction:"horizontal",
                    container:"layergrid",
				h_align:"left",
				v_align:"bottom",
				h_offset:80,
				v_offset:70,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span><span class="tp-bullet-wrap"></span>'
			}
		},
		responsiveLevels:[1240,1240,778,480],
		visibilityLevels:[1240,1240,778,480],
		gridwidth:[1920,1920,778,480],
		gridheight:[1000,1000,600,500],
		lazyType:"none",
		parallax: {
			type:"mouse+scroll",
			origo:"enterpoint",
			speed:400,
          speedbg:0,
          speedls:0,
			levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		disableProgressBar:"on",
		hideThumbsOnMobile:"off",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:0,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:false,
		}
	});

	// Home 04
	$("#rev_slider_4_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"auto",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"off",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"off",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				},
				right: {
					h_align:"right",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"larev-dot2",
				hide_onleave:false,
				direction:"horizontal",
				h_align:"left",
				v_align:"bottom",
				h_offset:80,
				v_offset:70,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span><span class="tp-bullet-wrap"></span>'
			}
		},
		responsiveLevels:[1200,1200,750,575],
		visibilityLevels:[1200,1200,750,575],
		gridwidth:[1920,1920,778,480],
		gridheight:[1000,1000,600,500],
		lazyType:"none",
		parallax: {
			type:"mouse+scroll",
			origo:"enterpoint",
			speed:400,
          speedbg:0,
          speedls:0,
			levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		disableProgressBar:"on",
		hideThumbsOnMobile:"off",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:0,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:false,
		}
	});


	// Home 06

	$("#rev_slider_6_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"fullscreen",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"off",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"off",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"bottom",
					h_offset:0,
                    v_offset:0
				},
				right: {
					h_align:"left",
					v_align:"bottom",
					h_offset:40,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"larev-dot2",
				hide_onleave:false,
				direction:"vertical",
				h_align:"right",
				v_align:"center",
				h_offset:80,
				v_offset:0,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span><span class="tp-bullet-wrap"></span>'
			}
		},
		responsiveLevels:[1240,1240,778,480],
		visibilityLevels:[1240,1240,778,480],
		gridwidth:[1920,1920,778,480],
		gridheight:[1000,1000,960,720],
		lazyType:"smart",
		parallax: {
			type:"mouse",
			origo:"slidercenter",
			speed:2000,
          speedbg:0,
          speedls:0,
			levels:[2,3,4,5,6,7,12,16,10,50,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		fullScreenAutoWidth:"off",
		fullScreenAlignForce:"off",
		fullScreenOffsetContainer: "",
		fullScreenOffset: "",
		disableProgressBar:"on",
		hideThumbsOnMobile:"on",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:0,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:true,
		}
	});

	// Home 07
	$("#rev_slider_7_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"auto",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"off",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"off",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				},
				right: {
					h_align:"right",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"larev-dot2",
				hide_onleave:false,
				direction:"vertical",
				h_align:"right",
				v_align:"center",
				h_offset:30,
				v_offset:0,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span><span class="tp-bullet-wrap"></span>'
			}
		},
		responsiveLevels:[1240,1240,778,480],
		visibilityLevels:[1240,1240,778,480],
		gridwidth:[1918,1918,778,480],
		gridheight:[944,944,600,500],
		lazyType:"none",
		parallax: {
			type:"mouse+scroll",
			origo:"enterpoint",
			speed:400,
          speedbg:0,
          speedls:0,
			levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		disableProgressBar:"on",
		hideThumbsOnMobile:"off",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:0,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:false,
		}
	});

	// Home 08

	$("#rev_slider_8_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"auto",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"off",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"off",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				},
				right: {
					h_align:"right",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"larev-dot2",
				hide_onleave:false,
				direction:"vertical",
				h_align:"right",
				v_align:"center",
				h_offset:30,
				v_offset:0,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span><span class="tp-bullet-wrap"></span>'
			}
		},
		responsiveLevels:[1240,1240,778,480],
		visibilityLevels:[1240,1240,778,480],
		gridwidth:[1920,1920,778,480],
		gridheight:[940,940,600,500],
		lazyType:"none",
		parallax: {
			type:"mouse+scroll",
			origo:"enterpoint",
			speed:400,
          speedbg:0,
          speedls:0,
			levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		disableProgressBar:"on",
		hideThumbsOnMobile:"off",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:0,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:false,
		}
	});

	// Home 09

	$("#rev_slider_9_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"auto",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"off",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"off",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				},
				right: {
					h_align:"right",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"larev-dot2",
				hide_onleave:false,
				direction:"vertical",
				h_align:"right",
				v_align:"center",
				h_offset:30,
				v_offset:0,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span><span class="tp-bullet-wrap"></span>'
			}
		},
		responsiveLevels:[1240,1240,778,480],
		visibilityLevels:[1240,1240,778,480],
		gridwidth:[1920,1920,778,480],
		gridheight:[810,810,600,500],
		lazyType:"none",
		parallax: {
			type:"mouse+scroll",
			origo:"enterpoint",
			speed:400,
          speedbg:0,
          speedls:0,
			levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		disableProgressBar:"on",
		hideThumbsOnMobile:"off",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:0,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:false,
		}
	});

	// Home 10

	$("#rev_slider_10_1").show().revolution({
		sliderType:"standard",
		sliderLayout:"auto",
		dottedOverlay:"none",
		delay:9000,
		navigation: {
			keyboardNavigation:"off",
			keyboard_direction: "horizontal",
			mouseScrollNavigation:"off",
             mouseScrollReverse:"default",
			onHoverStop:"off",
			arrows: {
				style:"gyges",
				enable:true,
				hide_onmobile:false,
				hide_onleave:false,
				tmp:'',
				left: {
					h_align:"left",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				},
				right: {
					h_align:"right",
					v_align:"center",
					h_offset:20,
                    v_offset:0
				}
			}
			,
			bullets: {
				enable:true,
				hide_onmobile:false,
				style:"larev-dot2",
				hide_onleave:false,
				direction:"vertical",
				h_align:"right",
				v_align:"center",
				h_offset:30,
				v_offset:0,
                space:5,
				tmp:'<span class="tp-bullet-title">{{title}}</span><span class="tp-bullet-wrap"></span>'
			}
		},
		responsiveLevels:[1240,1240,778,480],
		visibilityLevels:[1240,1240,778,480],
		gridwidth:[1920,1920,778,480],
		gridheight:[950,950,600,500],
		lazyType:"none",
		parallax: {
			type:"mouse+scroll",
			origo:"enterpoint",
			speed:400,
          speedbg:0,
          speedls:0,
			levels:[5,10,15,20,25,30,35,40,45,46,47,48,49,50,51,55],
		},
		shadow:0,
		spinner:"spinner0",
		stopLoop:"off",
		stopAfterLoops:-1,
		stopAtSlide:-1,
		shuffle:"off",
		autoHeight:"off",
		disableProgressBar:"on",
		hideThumbsOnMobile:"off",
		hideSliderAtLimit:0,
		hideCaptionAtLimit:0,
		hideAllCaptionAtLilmit:0,
		debugMode:false,
		fallbacks: {
			simplifyAll:"off",
			nextSlideOnWindowFocus:"off",
			disableFocusListener:false,
		}
	});

})(jQuery);