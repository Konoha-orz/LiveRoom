function convertPic2Webp(e){var t=/^(https?:\/\/i[5-9]?\.((h2|ssl)\.)?pdim.gs\/[^.]*)\.(jpg|jpeg|png)$/i;return PDR.isSupportWebp&&e?e.replace(t,"$1.webp"):e}!function(e){"function"==typeof define&&define.amd?define(["jquery"],e):e(window.jQuery||window.Zepto)}(function(e,t){function r(){}function a(e,t){var r;return r=t._$container==d?("innerHeight"in _?_.innerHeight:d.height())+d.scrollTop():t._$container.offset().top+t._$container.height(),r<=e.offset().top-t.threshold}function n(t,r){var a;return a=r._$container==d?d.width()+(e.fn.scrollLeft?d.scrollLeft():_.pageXOffset):r._$container.offset().left+r._$container.width(),a<=t.offset().left-r.threshold}function o(e,t){var r;return r=t._$container==d?d.scrollTop():t._$container.offset().top,r>=e.offset().top+t.threshold+e.height()}function i(t,r){var a;return a=r._$container==d?e.fn.scrollLeft?d.scrollLeft():_.pageXOffset:r._$container.offset().left,a>=t.offset().left+r.threshold+t.width()}function l(e,t){var r=0;e.each(function(l,c){function f(){s.trigger("_lazyload_appear"),r=0}var s=e.eq(l);if(!(s.width()<=0&&s.height()<=0||"none"===s.css("display")))if(t.vertical_only)if(o(s,t));else if(a(s,t)){if(++r>t.failure_limit)return!1}else f();else if(o(s,t)||i(s,t));else if(a(s,t)||n(s,t)){if(++r>t.failure_limit)return!1}else f()})}function c(e){return e.filter(function(t,r){return!e.eq(t)._lazyload_loadStarted})}function f(e,t){function r(){i=0,l=+new Date,o=e.apply(a,n),a=null,n=null}var a,n,o,i,l=0;return function(){a=this,n=arguments;var e=new Date-l;return i||(e>=t?r():i=setTimeout(r,t-e)),o}}var s,_=window,d=e(_),p={threshold:500,failure_limit:0,event:"scroll",effect:"show",effect_params:null,container:_,data_attribute:"original",data_srcset_attribute:"original-srcset",skip_invisible:!0,appear:r,load:r,vertical_only:!1,check_appear_throttle_time:300,url_rewriter_fn:r,no_fake_img_loader:!1,placeholder_data_img:"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC",placeholder_real_img:"http://ditu.baidu.cn/yyfm/lazyload/0.0.1/img/placeholder.png"};s=function(){var e=Object.prototype.toString;return function(t){return e.call(t).replace("[object ","").replace("]","")}}(),e.fn.hasOwnProperty("lazyload")||(e.fn.lazyload=function(t){var a,n,o,i=this;return e.isPlainObject(t)||(t={}),e.each(p,function(r,a){-1!=e.inArray(r,["threshold","failure_limit","check_appear_throttle_time"])?"String"==s(t[r])?t[r]=parseInt(t[r],10):t[r]=a:"container"==r?(t.hasOwnProperty(r)?t[r]==_||t[r]==document?t._$container=d:t._$container=e(t[r]):t._$container=d,delete t.container):!p.hasOwnProperty(r)||t.hasOwnProperty(r)&&s(t[r])==s(p[r])||(t[r]=a)}),a="scroll"==t.event,o=0==t.check_appear_throttle_time?l:f(l,t.check_appear_throttle_time),n=a||"scrollstart"==t.event||"scrollstop"==t.event,i.each(function(a,o){var l=this,f=i.eq(a),s=f.attr("src"),_=f.attr("data-"+t.data_attribute),d=t.url_rewriter_fn==r?_:t.url_rewriter_fn.call(l,f,_),p=f.attr("data-"+t.data_srcset_attribute),u=f.is("img");return 1==f._lazyload_loadStarted||s==d?(f._lazyload_loadStarted=!0,void(i=c(i))):(f._lazyload_loadStarted=!1,u&&!s&&f.one("error",function(){f.attr("src",t.placeholder_real_img)}).attr("src",t.placeholder_data_img),f.one("_lazyload_appear",function(){function a(){n&&f.hide(),u?(p&&f.attr("srcset",p),d&&f.attr("src",convertPic2Webp(d))):f.css("background-image",'url("'+convertPic2Webp(d)+'")'),n&&f[t.effect].apply(f,o?t.effect_params:[]),i=c(i)}var n,o=e.isArray(t.effect_params);f._lazyload_loadStarted||(n="show"!=t.effect&&e.fn[t.effect]&&(!t.effect_params||o&&0==t.effect_params.length),t.appear!=r&&t.appear.call(l,f,i.length,t),f._lazyload_loadStarted=!0,t.no_fake_img_loader||p?(t.load!=r&&f.one("load",function(){t.load.call(l,f,i.length,t)}),a()):e("<img />").one("load",function(){a(),t.load!=r&&t.load.call(l,f,i.length,t)}).attr("src",d))}),void(n||f.on(t.event,function(){f._lazyload_loadStarted||f.trigger("_lazyload_appear")})))}),n&&t._$container.on(t.event,function(){o(i,t)}),d.on("resize load",function(){o(i,t)}),e(function(){o(i,t)}),this})});