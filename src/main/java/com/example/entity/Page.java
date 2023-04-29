package com.example.entity;

import lombok.Data;

/**
 * @Author: shlin
 * @Date: 2023/4/28 - 04 - 28 - 16:11
 * @Description: com.example.entity 封装分页相关的信息
 * @Version: 1.0
 */
@Data
public class Page {
    private int current = 1;//当前页码
    private int limit = 10; // 显示上限
    private int rows; //数据总数，用于计算总页数
    private String path; // 查询路径，用于复用分页链接

    public void setCurrent(int current) {
        if(current>1){
            this.current = current;
        }
    }

    public void setRows(int rows) {
        if(rows>=0){
            this.rows = rows;
        }
    }

    public void setLimit(int limit) {
        if(limit>=1 && limit <=100){
            this.limit = limit;
        }

    }

    //获取当前页的起始行
    public int getOffset(){
        return (current-1) * limit;
    }

    //获取总的页数
    public int getTotal(){
        if(rows % limit ==0){
            return rows/limit;
        }else{
            return rows/limit+1;
        }
    }

    //获取起始页码
    public int getFrom(){
        int from = current-2;
        return from<1?1:from;
    }

    public int getTo(){
        int to = current+2;
        int total = getTotal();
        return to>getTotal()?total:to;
    }
}
