星遇
===
## api

    (1)首页星空 GET /api/starts
    
    成功：{
        "code": 0,
        "message": "successful",
        "data": [
            {
                "startId": 1,
                "label": "null",
                "gender": "null",
                "avatar": "null",
                "startname": "star0"
            },
           {
               "startId": 2,
                "label": "null",
               "gender": "null",
                "avatar": "null",
               "startname": "star1"
           }
        ]
    }



    (2)守护后获取个人资料 GET /api/star

    成功：{
        "code": 0,
       "message": "successful",
       "data": {
            "startId": 2,
            "label": "null",
            "gender": "null",
            "avatar": "null",
            "startname": "star1"
            "starword":"xxx"
            "date": "03月10日 12:44",
            "days": 0,
        }
    }
    失败：{"code":10,"message": "未被守护"}


    (3)放弃  POST /api/abandon
    成功：{"code":0,"message": "successful"}
    失败：{"code":9,"message": "已经放弃了"}

    (4)发布星语 POST /api/publish 
    发布内容为请求体的全部内容
    成功：{"code":0,"message": "successful"}

    (5)点击星星 POST /api/star?starId=x (starId为首页星空获取的starId)
    成功: {"code":0,"message": "守护成功"}
    失败: {"code":5,"message": "今天没有机会了"}
         {"code":3,"message": "你正在守护别人"}
         {"code":4,"message": "你已经被守护了"}
         {"code":1,"message": "还没到时间哦"}
         {"code":2,"message": "此人刚被守护"}
         {"code":7,"message": "用户不存在"}
         {"code":11,"message": "不能守护自己"} 
         
    (6)排行榜 GET /api/rankChart 
      成功：{
       "code": 0,
       "message": "successful",
        "data": [
           {
               "starname1": "堂皇",
               "starname2": "zlz",
               "avatar1": "http://star-avatar.oss-cn-beijing.aliyuncs.com/20.jpg?x-oss-process=image/resize,m_fixed,w_100,h_100",
               "avatar2": " http://star-avatar.oss-cn-beijing.aliyuncs.com/star.jpg?x-oss-process=image/resize,m_fixed,w_100,h_100",
               "days": 1
            },
            {
               "starname1": "哈哈哈哈哈哈",
               "starname2": "机器人5号",
               "avatar1": "http://star-avatar.oss-cn-beijing.aliyuncs.com/38.jpg?x-oss-process=image/resize,m_fixed,w_100,h_100",
               "avatar2": "http://star-avatar.oss-cn-beijing.aliyuncs.com/star.jpg?x-oss-process=image/resize,m_fixed,w_100,h_100",
                "days": 1
           }
        ]
    }    
    
    (7)加载聊天信息 GET /api/chatInfo 
     成功：{
        "code": 0,
        "message": "successful",
        "data": {
            "avatar1": "http://star-avatar.oss-cn-beijing.aliyuncs.com/37.jpg?x-oss-process=image/resize,m_fixed,w_100,h_100",
            "avatar2": "http://star-avatar.oss-cn-beijing.aliyuncs.com/star.jpg?x-oss-process=image/resize,m_fixed,w_100,h_100",
            "starname1": "rong",
            "starname2": "star",
            "days": 0
       }
    }
    
    (8)获取未读消息数量 GET /api/messageNum
    成功：{"code":0,"message":"successful","data":0}
    
    (9)获取消息 GET /api/message
    成功：{
       "code": 0,
       "message": "successful",
       "data": [
            {
                "chatStarname": "null",
                "type": "null",
                "date": "2018-03-11 19:35:54.0",
               "chatAvatar": "xxx"
            }
        ]
    }
    
    
    
    ***注：
      token放在请求头中，键:authorization
    出错： {"code":-1,"message": "没有权限"}
    
      
