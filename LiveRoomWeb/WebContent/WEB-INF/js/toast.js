var toast = (function(){
	var DEFAULTMESSAGE = {
		duration: 2000,
		text: "关键字不能为空！",
		type: "info",
		isShow: false
	}
	
	var ToastConstructor = Vue.extend({
		template: `	
			<transition name="drop">
				<div id="alert" :class="['message','message-'+type]"  style="z-index:2000;" v-if="isShow">
				<p class="message-content">{{text}}</p>
				</div>
			</transition>`,
		data: function(){
			var data = {};
			data.duration = DEFAULTMESSAGE.duration;
			data.text = DEFAULTMESSAGE.text;
			data.timer = null;
			data.type = DEFAULTMESSAGE.type;
			data.isShow = DEFAULTMESSAGE.isShow;
			
			return data;
		},		
		mounted(){
		},
		methods: {
			show(){
				var me = this;
				clearInterval(this.timer);
				this.isShow = true;
				this.timer = setInterval(function(){
					me.hide();
				},this.duration)
			},
			hide(){
				this.isShow = false;
			}
		}
	});

	function destory(instance){
	  let el = instance.$el;
	  instance.$destroy(true);
	  el.parentNode.removeChild(el); 
	}
	
	function Toast(options) {
		  options = options || {};
		  var instance = new ToastConstructor();

	      options.text && (instance.text = options.text);
	      options.duration && (instance.duration = options.duration);
	      options.type && (instance.type = options.type);
		  instance.$on('destory', () => {
		    setTimeout(() => destory(instance), 1000);
		  });

		  let parent = options.parent;
		  let el = document.createElement("div");

		  if(!parent || !(parent instanceof HTMLElement)) parent = document.body; 
		  parent.appendChild(el);

		  instance.$mount(el);
		  instance.show();
		  
		  return instance;
	};
	
	return {
		init: Toast
	}
})();
