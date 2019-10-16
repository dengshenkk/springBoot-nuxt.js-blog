package com.ds.blog.utils;

import com.ds.blog.VO.ResultVO;

public class ResultVOUtils {
    public static ResultVO success(Object data) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode("200");
        resultVO.setMsg("操作成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(String msg) {
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setCode("500");
        objectResultVO.setMsg(msg);
        objectResultVO.setData(null);
        return objectResultVO;
    }
}
