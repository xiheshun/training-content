package cn.zql.goodscommon.vo;

import lombok.Data;

//向前端返回需要的结果 包含:状态码、提示信息、返回值等
@Data
public class ResultVo {
    private int code;
    private String msg;
    private Object data;
    private ResultVo(){}
    //成功
    public static ResultVo ok(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMsg("ok");
        resultVo.setData(data);
        return resultVo;
    }
    //重载
    public static ResultVo ok(){
        return ResultVo.ok(null);
    }
    //失败
    public static ResultVo error(){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg("error");
        return resultVo;
    }

    public static ResultVo error(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(500);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
