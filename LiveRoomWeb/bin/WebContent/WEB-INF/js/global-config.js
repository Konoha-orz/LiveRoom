var GLOBAL_CONFIG = {
  // 两周年
  'DISABLE_2ND_HOLIDAY':false,
  // wegame合作游戏配置
   WEGAME_CONFIG:{
   'show': false,
   'cateConf': {
    'wegame':{type:0},
    'zhuji': {type:0},
    'ttts': {type:0},
    'pubg': {type:0},
    'mc': {type:0},
    'hjjd': {type:0},
    'ftg': {type:0},
    'sv': {type:1,href:'http://plat.tgp.qq.com/rail/live.html?game_id=2000064',gameid:2000064}
   }
  },
  SKIN_CONFIG : {
  "roomid":{
    "493035": "/cmstatic/skin/zhuxian.css",
    "10121": "/cmstatic/skin/zhuxian.css",
    "341879": "/cmstatic/skin/zhuxian.css"
  },
  "cate": {
   "acg":"/cmstatic/skin/acg.css"
   }
  },
  "SHOW_WANGWEN": false,
  "PANDA_VIDEO_PLAYER_URL": "http://s9.pdim.gs/static/ab0f83f3a167793f.swf",
  "PANDA_PLAYER_URL": "http://s9.pdim.gs/static/ebad7758c2986c30.swf",
  "PANDA_PLAYER_URL_V2": "http://s9.pdim.gs/static/c8e8226cec5e1719.swf",
  "CHAT_SWF_URL": "http://s6.pdim.gs/static/17bf20eb110c217e.swf",
  "PANDA_DOWNLOAD_PAGES_URL": "https://dl.pdim.gs/clients/pc/PandaTV/download/PandaTV_Setup.exe",
  "DEFAULT_ROOM_CHAT_TEXT": "快和大家一起聊天吧~~",
  "TIME_LIMIT_TASK_MONTH": "派送竹子福利",
  // 付费弹幕开关
  "PAY_BARRAGE_SWITCH": true,
  // 付费弹幕：有折扣的用户等级需大于的level
  "PAY_BARRAGE_SALE_LEVEL": 19,
  // 单条弹幕的原始价格
  "PAY_BARRAGE_PRICE": 20,
  // 单条弹幕的折扣
  "PAY_BARRAGE_DISCOUNT": 0.1,
  // 需要做礼物横幅分流保护的消息类型          
  "BYPASS_PROTECT_GIFT_MESSAGE_TYPE": [311, 331, 332, 1339],
  "CALL_PLAYER_MESSAGE_TYPE": ["312", "610", "640", "666", "1001","4001","4002","4003"],
  "CALL_PLAYER_GIFT_MESSAGE_TYPE": ["311", "331","332","1107", "1103", "1203", "316", "317", "3001", "318","1233","2001","1263","3303","1279","1291","1299","1300","3304","2002","1000","3005","1339"],
  "PANDA_ROOM_RESTRICTED_SWITCH": false,
  "PANDA_PLAYER_EFFECT": {
    "EFFECT_MANAGER": "http://s8.pdim.gs/static/026abede6abd3cd0.swf",
    "EFFECT_DANMU": "http://s6.pdim.gs/static/1d0e8970eb51bb9f.swf",
    "EFFECT_GIFT": "http://s6.pdim.gs/static/0b7fde420e68d99d.swf",
    "EFFECT_LIST": {
      "EFFECT_FoTiaoQiang": "http://s8.pdim.gs/static/96a46cf9d7d80fda.swf",
      "Screen_Mask": "http://s7.pdim.gs/static/da8ce6e0b5685620.swf",
      "Effect_LuckBox": "http://s9.pdim.gs/static/b2c866425f1650bb.swf",
      "Windy": "http://s8.pdim.gs/static/be1cad7212308ca0.swf",
      "pandakill": [["430909","356223"],"http://s9.pdim.gs/static/f6f6777537dde17e.swf"],
      "Effect_videoxx": [["11167","71403","47393","1140107","879503","5000","743099","401901","286463","4001","71403","821229","371037"],"http://s9.pdim.gs/static/dbd41de9f213919a.swf"]
    },
     "GIFT_LIST": {
        "eventids":["mall-bsw","mall-pgc-bigeat","mall-pgc-zhizhang"],
        "giftsList":{
          "gift_311":{"swf":"http://s8.pdim.gs/static/e215123a020b5d10.swf","className":"gift_311","txt1":"请","c1":"#ffffff","txt2":"吃了","c2":"#ffffff","txt3":"个佛跳墙，快来抢福袋吧！","c3":"#ffffff"},
          "gift_1203":{"swf":"http://s9.pdim.gs/static/76ca4b6875e5fda1.swf","className":"gift_1203","txt1":"在《小葱秀》直播间爆发了","c1":"#ffffff","txt2":"","c2":"#ffffff","txt3":"次洪荒之力，快来抢竹子吧！","c3":"#ffffff"},
          "gift_1263":{"swf":"http://s5.pdim.gs/static/e851c46dd9df6746.swf","className":"gift_1263","txt1":"射出“智慧之光","c1":"#ba3f72","txt2":"","c2":"#ffffff","txt3":"束，照亮了制杖世界！","c3":"#ba3f72"},
          "gift_1279":{"swf":"http://s9.pdim.gs/static/4c7973a26245f5d1.swf","className":"gift_1279","txt1":"在开心相对论投食了 x","c1":"#fff4e9","txt2":"","c2":"#ffffff","txt3":"个开心大麻花，快来分享吧！","c3":"#fff4e9"},
          "gift_1299":{"swf":"http://s5.pdim.gs/static/892a6675ac9b79e0.swf","className":"gift_1299","txt1":"给奇行怪撞赠送了侠客行","c1":"#ffdd99","txt2":"","c2":"#ffdd99","txt3":"个!","c3":"#ffdd99"},
          "gift_1300":{"swf":"http://s9.pdim.gs/static/64608ca6fe4fe67c.swf","className":"gift_1300","txt1":"为侣行献上了赞歌","c1":"#95ffd7","txt2":"","c2":"#ffdd99","txt3":"首!","c3":"#95ffd7"},
          "gift_331":{"swf":"http://s6.pdim.gs/static/b92636c7c83262ac.swf","className":"gift_331","txt1":"陪","c1":"#ffffff","txt2":"去看了","c2":"#ffffff","txt3":"场流星雨，1个福袋开3次，快去抢吧!","c3":"#ffffff"},
          "gift_332":{"swf":"http://s5.pdim.gs/static/b2db8c733a863bb2.swf","className":"gift_332","txt1":"陪","c1":"#ffffff","txt2":"一起浪漫旅行","c2":"#ffffff","txt3":"次，1个福袋开3次，快去抢吧!","c3":"#ffffff"},
          "gift_330358ef11afea3d187ab1a9b8df":{"swf":"http://s9.pdim.gs/static/096f40ed61b29e6a.swf","className":"gift_330358ef11afea3d187ab1a9b8df","txt1":"请","c1":"#ffd688","txt2":"吃了","c2":"#ffd688","txt3":"只烤鸭，才吃半饱！","c3":"#ffd688"},
          "gift_3303597efd86755d2ce7641cd518":{"swf":"http://s5.pdim.gs/static/96bb8af0b1003118.swf","className":"gift_3303597efd86755d2ce7641cd518","txt1":"请","c1":"#ffd688","txt2":"的直播间已有","c2":"#ffffff","txt3":"人上车，快去围观！","c3":"#ffffff"},
          "gift_1291":{"swf":"http://s6.pdim.gs/static/d6a5c343e24a68d0.swf","className":"gift_1291","txt1":"为熊猫307达到","c1":"#ffffff","txt2":"","c2":"#ffffff","txt3":"个小目标!","c3":"#ffffff"},
          "gift_3304":{"swf":"http://s5.pdim.gs/static/95d58d3d84a0252f.swf","className":"gift_3304","txt1":"给","c1":"#ffffff","txt2":"赠送了香蕉球","c2":"#ffffff","txt3":"个!","c3":"#ffffff"},
          "gift_330359ad4846b5061c7d30af12cb":{"swf":"http://s9.pdim.gs/static/ea8e36c880a1424e.swf","className":"gift_330359ad4846b5061c7d30af12cb","txt1":"请","c1":"#ffffff","txt2":"吃了","c2":"#ffffff","txt3":"个金色佛跳墙，快来抢福袋吧！","c3":"#ffffff"},
          "gift_330359e7119df1eb654f37d39619":{"swf":"http://s8.pdim.gs/static/c8daf33dac48b6c4.swf","className":"gift_330359e7119df1eb654f37d39619","txt1":"请","c1":"#ffffff","txt2":"吃了","c2":"#ffffff","txt3":"个金色佛跳墙，快来抢福袋吧！","c3":"#ffffff"},
          "gift_330359b6393442846ec72031a4e2":{"swf":"http://s6.pdim.gs/static/27e3fb33af3fa09a.swf","className":"gift_330359b6393442846ec72031a4e2","txt1":"","c1":"#ffffff","txt2":"在充值抽奖活动中获得了","c2":"#ffffff","txt3":"个金色佛跳墙！","c3":"#ffffff"},
          "gift_330359a7ec3c23e8e5cb838274b9":{"swf":"http://s7.pdim.gs/static/1e00202c9f367bf9.swf","className":"gift_330359a7ec3c23e8e5cb838274b9","txt1":"","c1":"#ffffff","txt2":"","c2":"#ffffff","txt3":"竹仙高能预警：现在充值，即有机会获得30个佛跳墙或100万竹子哦","c3":"#ffdd99"},
          "gift_330359c21b9c100e3953fb3c856c":{"swf":"http://s8.pdim.gs/static/12edddb18294fa3d.swf","className":"gift_330359c21b9c100e3953fb3c856c","txt1":"请","c1":"#ffffff","txt2":"吃了","c2":"#ffffff","txt3":"个佛跳墙，快来抢福袋吧！","c3":"#ffffff"},
           "gift_3005":{"swf":"http://s8.pdim.gs/static/8785f9e91abe0d2e.swf","className":"gift_3005","txt1":"","c1":"#ffffff","txt2":"","c2":"#ffffff","txt3":"在2周年活动中找到了礼物福袋！快来抢啊！","c3":"#fb7152"},
         "gift_1339":{"swf":"http://s5.pdim.gs/static/bc89098c8a724ced.swf","className":"gift_1339","txt1":"给","c1":"#ffffff","txt2":"King Of Panda献上至尊金腰带","c2":"#ffffff","txt3":"条!","c3":"#ffffff"},
          "gift_330359cb90e768b764641aeae5ce":{"swf":"http://s8.pdim.gs/static/8789b68f28e7c612.swf","className":"gift_330359cb90e768b764641aeae5ce","txt1":"为","c1":"#ffffff","txt2":"在2周年盛典送出10000×","c2":"#ffffff","txt3":"个打CALL，燃爆了！","c3":"#ffffff"},
          "gift_330359a7ecf623e8e5cb838274ba":{"swf":"http://s9.pdim.gs/static/cba6a0509bf8729d.swf","className":"gift_330359a7ecf623e8e5cb838274ba","txt1":"","c1":"#ffffff","txt2":"","c2":"#ffffff","txt3":"","c3":"#ffdd99"}
         }
    }
  },
  "CHARGE_DESCRIPTION": "充10元 送60元烤鱼、饭团",
  "GIFT_COMBO_CONF": {
    "gid_593e6f2c68b76402fa9cac03": {
      "name": "神之眼",
      "basePrice": 0,
      "price": 2
    },
    "gid_593e6f9db5061c53d748c573": {
      "name": "啪啪打脸",
      "basePrice": 0,
      "price": 2
    }
  },
  "GIFT_STYLE_CONF": {
    "佛跳墙": "ftq",
    "龙虾": "lx",
    "烤鱼": "ky",
    "饭团": "ft",
    "乱斗之王": "room-gift-anim-fighting",
    "烤鸭": "room-gift-anim-duck",
    "皮皮虾": "room-gift-anim-shrimp",
    "666": "room-gift-anim-666",
    "？？？": "room-gift-anim-q",
    "GG": "room-gift-anim-gg",
    "总冠军": "room-gift-anim-champion",
    "比心": "room-gift-anim-heart",
    "扯": "room-gift-anim-chitchat",
    "拥抱": "room-gift-anim-embrace",
    "稳": "room-gift-anim-steady",
    "中国队加油": "room-gift-anim-go",
    "情天竹": "room-gift-anim-qtz",
    "扳手": "room-gift-anim-spanner",
    "高压锅": "room-gift-anim-cooker",
    "胡萝卜": "room-gift-anim-carrot",
    "棒棒糖": "room-gift-anim-lollipop",
    "气球": "room-gift-anim-balloon",
    "手枪": "room-gift-anim-pistol",
    "老婆饼": "room-gift-anim-cake",
    "河蟹": "room-gift-anim-crab",
    "Boom": "room-gift-anim-boom",
    "国服第一": "room-gift-anim-no1",
    "计算器": "room-gift-anim-calc",
    "鱼饵": "room-gift-anim-bait",
    "桃汁": "room-gift-anim-juice",
    "菜": "room-gift-anim-vegetable",
    "盐": "room-gift-anim-salt",
    "橘子": "room-gift-anim-orange",
    "玩吧小玩": "room-gift-anim-mingift",
    "吃鸡": "room-gift-anim-chicken",
    "神之眼": "room-gift-anim-eyes",
    "啪啪打脸": "room-gift-anim-face",
    "洗澡澡": "room-gift-anim-wash",
    "不存在的": "room-gift-anim-impossible",
    "打脸": "room-gift-anim-smackface",
    "就是混": "room-gift-anim-dawdling",
    "么么哒": "room-gift-anim-memeda",
    "瞎": "room-gift-anim-blind",
    "爱洛": "room-gift-anim-ailuo",
    "猫仔": "room-gift-anim-maozai",
    "葱": "room-gift-anim-cong",
    "菠萝包": "room-gift-anim-boluobao",
    "泡面": "room-gift-anim-paomian",
    "JK短裙": "room-gift-anim-jk",
    "打鸡": "room-gift-anim-daji",
    "一万八": "room-gift-anim-1w8",
    "神龙": "room-gift-anim-dragon",
    "口罩": "room-gift-anim-kouzhao",
    "蛤蟆皮": "room-gift-anim-hamap",
    "无敌": "room-gift-anim-wudi",
    "丫脖": "room-gift-anim-yabo",
    "正义地球人": "room-gift-anim-diqiuren",
    "呼啦圈": "room-gift-anim-hulaquan",
    "比翼双飞": "room-gift-anim-biyifly",
    "品客薯片": "room-gift-anim-pinke"
  },
  "H5_BANNER_CONF": {
   "3005": {
     cls: "2years-gift-fudai",
     giftinfo: {
        url:'/sp/anniversary.html',
        fromTo: '',
        beforeCombo: '',
        afterCombo: '在2周年活动中找到了礼物福袋！快来抢啊！'
      }
    },
    "3303_59c21b9c100e3953fb3c856c": {
      cls: "pinkftq",
      giftinfo: {
        fromTo: '请',
        beforeCombo: '吃了',
        afterCombo: '个佛跳墙，快来抢福袋吧！'
      }
    },
    "3303_59ad4846b5061c7d30af12cb": {
      cls: "goldftq",
      giftinfo: {
        fromTo: '请',
        beforeCombo: '吃了',
        afterCombo: '个金色佛跳墙，快来抢福袋吧！'
      }
    },
    "3303_59a7ec3c23e8e5cb838274b9": {
      cls: "energy-ready",
      giftinfo: {
        url:'https://pay.panda.tv',
        hideFromName: true,
        hideToName:true,
        fromTo: '',
        beforeCombo: '竹仙高能预警：现在充值，即有机会获得30个佛跳墙或100万竹子哦',
        afterCombo: ''
      }
    },
    "3303_59a7ecf623e8e5cb838274ba": {
      cls: "energy-bomb",
      giftinfo: {
        url:'/sp/getlucky.html',
        hideFromName: true,
        fromTo: '',
        beforeCombo: '',
        afterCombo: ''
      }
    },
    "3303_59b6393442846ec72031a4e2": {
      cls: "energy-bigprize",
      giftinfo: {
        url:'/sp/getlucky.html',
        hideToName: true,
        beforeCombo: '在充值抽奖活动中获得了',
        afterCombo: '个金色佛跳墙'
      }
    },
    "3303_58ef11afea3d187ab1a9b8df": {
      cls: "duck",
      giftinfo: {
        fromTo: '请',
        beforeCombo: '吃了',
        afterCombo: '只烤鸭，才吃半饱！'
      }
    },
   "3303_597efd86755d2ce7641cd518": {
      cls: "station",
      giftinfo: {
        hideFromName: true,
        fromTo: '',
        beforeCombo: '的直播间已有',
        afterCombo: '人上车，快去围观！'
      }
    },
    "3304": {
      cls: "banana",
      giftinfo: {
        fromTo: '给',
        beforeCombo: '赠送了香蕉球',
        afterCombo: '个'
      }
    },
    "311": {
      cls: "311",
      giftinfo: {
        fromTo: '请',
        beforeCombo: '吃了',
        afterCombo: '个佛跳墙，快来抢福袋吧！'
      }
    },
    "331": {
     cls: "331",
     giftinfo: {
       fromTo: '陪',
       beforeCombo: '去看了',
       afterCombo:'场流星雨，一个福袋开3次，快去抢吧！'
     }
    },
    "332": {
      cls: "332",
      giftmap: {
        roomId: 'data.to.xid'
      },
      giftinfo: {
        url: 'https://xingyan.panda.tv/',
        fromTo: '陪',
        beforeCombo: '一起浪漫旅行',
        afterCombo: '次，1个福袋开3次，快去抢吧！'
      }
    },
    "1339": {
      cls: "kop",
      giftinfo: {
        hideToName: true,
        fromTo: '给',
        beforeCombo: 'King of Panda献上至尊金腰带',
        afterCombo: '条！'
      }
    },
    "3303_59cb90e768b764641aeae5ce": {
     cls: "playcall",
     giftinfo: {
        url:'/sp/anniversarycall.html',
        fromTo: '为',
        beforeCombo: '在2周年盛典送出10000×',
        afterCombo: '个打CALL，燃爆了。'
      }
    }
  },
  "FUDAI_MSG_TYPE": ['311','3304','306_59ad4846b5061c7d30af12cb','306_59c21b9c100e3953fb3c856c'],
  "DAMMU_ANIMATE": {
    identity_lowest: 10000,
    identity_exeption: 10000,
    sp_identity_lowest: 10000,
    level_lowest: 10000,
    rids: []
  },
  "ROOMINFO_FORBID_WORD": false,
  "FORCE_FLASH_CONNECT": false,
  "HIDE_SEND_GIFT_ROOMS": ["480709", "611798", "611799", "611800", "611801", "611802", "611803", "611804", "611805", "611806", "611807", "611808", "614085"],
  "H5PLAYER_P2P_ROOMS":["556105","10333","353273","1357627","13745"],
  "H5PLAYER_BLUERAY_ROOMS":["7000", "371037"],
  "H5PLAYER_BLUERAY_LINES":['3', '4', '7', '8', '11', '12'],
  "H5PLAYER_CDN_LINES": [{
      name: "网宿",
      flag: "w",
      lines: ['3', '4']
    },
    {
      name: "星域",
      flag: "x",
      lines: ['7', '8']
    },
    {
      name: "阿里云",
      flag: "a",
      lines: ['11', '12']
    },
    {
      name: "乐视",
      flag: "l",
      lines: ['9', '10']
    },
    {
      name: "帝联",
      flag: "d",
      lines: ['13']
    },{
      name: "七牛",
      flag: "q",
      lines: ['21']
    },
    {
      name: "百度云",
      flag: "b",
      lines: ['27']
    },
    {
      name: "腾讯云",
      flag: "t",
      lines: ['28', '29']
    },
    {
      name: "金山云",
      flag: "j",
      lines: ['30']
    }
  ],
  "SIDEBAR_EVENTS": [{"title":"\u4f4d\u7f6e1","name":"S7\u603b\u51b3\u8d5b","link":"http:\/\/www.panda.tv\/371037","tag":"\u8d5b\u4e8b","color":"red","colornew":"red"},{"title":"\u4f4d\u7f6e2","name":"KPL\u804c\u4e1a\u8054\u8d5b","link":"http:\/\/www.panda.tv\/kpl","tag":"\u8d5b\u4e8b","color":"red","colornew":"red"},{"title":"\u4f4d\u7f6e3","name":"King Of Panda","link":"http:\/\/king.pgc.panda.tv\/?channel=web_pgc-tjw-ch_hdbq","tag":"\u7cbe\u54c1","color":"red","colornew":"red"}],
  "CARD_AUTO_VIDEO_PLAY": {
    page: 1,
    num: 0
  },
  "ZHUXIAN_ACTIVITY_USER": ['3049236', '79187306', '80936110']
};