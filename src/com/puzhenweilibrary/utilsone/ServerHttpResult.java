package com.puzhenweilibrary.utilsone;

import com.alibaba.fastjson.JSON;

/**
 * 请求服务器结果
 *
 * @author XiaoWei
 * @date 2015-5-5
 */
public final class ServerHttpResult {

    private boolean success;// 判断接口数据是否成功
    private String msg;// 请求对应的消息,success为false时候，提示用
    private Object obj;// 请求成功对应的数据

    public ServerHttpResult() {

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        if (obj != null) {
            return JSON.toJSONString(this.obj);
        }
        return null;
    }
}