package com.aaa.controller;


import com.aaa.pojo.*;
import com.aaa.service.GoodsService;
import com.aaa.service.GoodsTypeService;
import com.alibaba.fastjson.*;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/findBook")
public class finfAllBookController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsTypeService goodsTypeService;

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/up")
    public String up(){
        return "update";
    }

    //分页条件查询所有的图书
    @GetMapping("findall")
    @ResponseBody
    public void findPg(SelectGoods goods, HttpServletResponse resp) throws IOException {
        System.out.println(111111);
        System.out.println(goods);
        if(null == goods){
            goods = new SelectGoods();
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Integer pageNum = goods.getPageNum();
        Integer pageSize = goods.getPageSize();
        String goodsName = goods.getGoodsName();
        Integer typeId = goods.getTypeId();
        goodsName = goodsName == null || goodsName==""?null:goodsName;
        pageNum = pageNum == null || pageNum == 0?1:pageNum;
        pageSize = pageSize == null?5:pageSize;
        if(null != typeId){
            typeId = typeId == -1?null:typeId;
        }

        goods.setStart((pageNum-1)*pageSize);
        goods.setPageNum(pageNum);
        goods.setPageSize(pageSize);
        goods.setGoodsName(goodsName);
        goods.setTypeId(typeId);
        List<GoodsVo> bs = goodsService.findBypage(goods);
        long num = goodsService.findByPageNum(goods);
        Integer intnum = Integer.valueOf(num+"");
        Message msg = new Message();
        msg.setRows(bs);
        msg.setTotal(intnum);
        out.print(JSON.toJSONStringWithDateFormat(msg,"yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat));

    }
    @GetMapping("/pubs")
    @ResponseBody
    public void pubs(HttpServletResponse response) throws IOException {
        System.out.println(123);
        List<GoodsType> pubs = goodsTypeService.SelectAll();
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(pubs));
    }
    @PostMapping("/doUpload")
    @ResponseBody
    public void doUpload(MultipartFile photo, HttpServletResponse resp) throws IOException {
        //定义真实的上传路径
        String realPath = "D:"+ File.separator+"photoimg";
        //访问路径
        String visitPath = "/photo"+File.separator;
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Map<String,String> result = new HashMap<>();
        //判断是否为空
        if(null ==photo){
            result.put("type","error");
            result.put("msg","请选择上传的图片");
            out.print(JSON.toJSONString(result));
            return;
        }
        //判断大小
        long size = photo.getSize();
        if(size > 2000000){
            result.put("type","error");
            result.put("msg","上传的图片超过限定大小，请上传2M以内的图片！");
            out.print(JSON.toJSONString(result));
            return;
        }
        //拿到图片的后缀
        int index = photo.getOriginalFilename().lastIndexOf(".");
        String suffix = photo.getOriginalFilename().substring(index);
        //判断后缀是否是图片
        if(!".jpg,.jpeg,.pgn,.gif".toUpperCase().contains(suffix.toUpperCase())){
            result.put("type","error");
            result.put("msg","必须上传指定格式的图片.jpg,.jpeg,.pgn,.gif");
            out.print(JSON.toJSONString(result));
            return;
        }
        //修改文件的名字
        String newFileName = System.currentTimeMillis()+""+suffix;
        //建立文件
        File file = new File(realPath,newFileName);
        //写入磁盘
        photo.transferTo(file);//把文件写入到指定的路径中；
        //返回给前端数据
        result.put("type","success");
        result.put("msg","上传成功！");
        result.put("fileName",newFileName);
        result.put("filePath",visitPath);
        out.print(JSON.toJSONString(result));
    }

    /*修改*/
    @PutMapping("/doUpdate")
    public String doUpdate(Goods goods){
        goodsService.update(goods);
        return "redirect:/findBook/index";
    }

    //删除
    @DeleteMapping("/doDel")
    public void doDel(Integer goodsId,HttpServletResponse resp)throws Exception{
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        System.out.println(goodsId);
        goodsService.delete(goodsId);
        out.print(JSON.toJSONString("ok"));

    }

    //添加
    @PostMapping("/doAdd")
    public String doAdd(Goods goods){
        goodsService.insert(goods);
        return "redirect:/findBook/index";
    }

    //测试
    @RequestMapping("/all")
    public String all(Model model){
        List<GoodsVo> goodsVos = goodsService.SelectAll();
        model.addAttribute("hello","hello world!");
        model.addAttribute("goods",goodsVos);
        return "Test";
    }

    @RequestMapping("/selectone")
    public String selectone(Model model){
        GoodsVo goodsVo = goodsService.QueryOne(1);
        model.addAttribute("goods",goodsVo);
        return "One";
    }

    @RequestMapping("/Test")
    public String Test(){
        return "UrlTest";
    }
}
