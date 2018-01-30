package com.lib.constant;

/**
 * 当服务器响应时，其状态行的信息为HTTP的版本号，状态码，及解释状态码的简单说明。现将5类状态码详细列出：
 */
public class HttpCodeConstant {
//① 客户方错误
public static final Integer HTTP_ERROR_100 = 100; //继续
public static final Integer HTTP_ERROR_101 = 101; //交换协议
//② 成功
public static final Integer HTTP_ERROR_200 = 200; //OK
public static final Integer HTTP_ERROR_201 = 201; //已创建
public static final Integer HTTP_ERROR_202 = 202; //接收
public static final Integer HTTP_ERROR_203 = 203; //非认证信息
public static final Integer HTTP_ERROR_204 = 204; //无内容
public static final Integer HTTP_ERROR_205 = 205; //重置内容
public static final Integer HTTP_ERROR_206 = 206; //部分内容
//③ 重定向
public static final Integer HTTP_ERROR_300 = 300; //多路选择
public static final Integer HTTP_ERROR_301 = 301; //永久转移
public static final Integer HTTP_ERROR_302 = 302; //暂时转移
public static final Integer HTTP_ERROR_303 = 303; //参见其它
public static final Integer HTTP_ERROR_304 = 304; //未修改（Not Modified）
public static final Integer HTTP_ERROR_305 = 305; //使用代理
//④ 客户方错误
public static final Integer HTTP_ERROR_400 = 400; //错误请求（Bad Request）
public static final Integer HTTP_ERROR_401 = 401; //未认证
public static final Integer HTTP_ERROR_402 = 402; //需要付费
public static final Integer HTTP_ERROR_403 = 403; //禁止（Forbidden）
public static final Integer HTTP_ERROR_404 = 404; //未找到（Not Found）
public static final Integer HTTP_ERROR_405 = 405; //方法不允许
public static final Integer HTTP_ERROR_406 = 406; //不接受
public static final Integer HTTP_ERROR_407 = 407; //需要代理认证
public static final Integer HTTP_ERROR_408 = 408; //请求超时
public static final Integer HTTP_ERROR_409 = 409; //冲突
public static final Integer HTTP_ERROR_410 = 410; //失败
public static final Integer HTTP_ERROR_411 = 411; //需要长度
public static final Integer HTTP_ERROR_412 = 412; //条件失败
public static final Integer HTTP_ERROR_413 = 413; //请求实体太大
public static final Integer HTTP_ERROR_414 = 414; //请求URI太长
public static final Integer HTTP_ERROR_415 = 415; //不支持媒体类型
//⑤ 服务器错误
public static final Integer HTTP_ERROR_500 = 500; //服务器内部错误
public static final Integer HTTP_ERROR_501 = 501; //未实现（Not Implemented）
public static final Integer HTTP_ERROR_502 = 502; //网关失败
public static final Integer HTTP_ERROR_504 = 504; //网关超时
public static final Integer HTTP_ERROR_503 = 505; //HTTP版本不支持

}
