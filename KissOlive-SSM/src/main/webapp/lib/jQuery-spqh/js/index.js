$(function() {
				var Panels = (function() {
					var panelLeft = document.querySelector('.panels__side--left');
					var panelRight = document.querySelector('.panels__side--right');
					var panelLeftTitle = document.querySelector('#panels_side_left_title');
					var panelRightTitle = document.querySelector('#panels_side_right_title');
					var panelLeft
					var openLeft = function() {
						panelLeft.classList.toggle('panels__side--left-active');
						panelRight.classList.toggle('panels__side--right-hidden');
					};
					var openRight = function() {
						panelRight.classList.toggle('panels__side--right-active');
						panelLeft.classList.toggle('panels__side--left-hidden');
					};
					var bindActions = function() {
						panelLeftTitle.addEventListener('click', openLeft, false);
						panelRightTitle.addEventListener('click', openRight, false);
					};
					var init = function() {
						bindActions();
					};
					return {
						init: init
					};
				}());
				Panels.init();
			});