package p2.service;

import p2.bean.Customer;


/**
 * @Author reguozhi
 * @Date 2021年7月27日
 * @Description CustomerList为Customer对象的管理模块，
 * 内部用数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法，
 * 供CustomerView调用
 * @Since version-1.0
 */


public class CustomerList {

    private Customer[] customers;//用来保存客户对象的数组
    private int total = 0; //已有的客户数
    int totalCustomer; //总共能容纳的客户数

    /**
     * @Description 用途：构造器，用来初始化customers数组
     * @param totalCustomer 指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer){
        this.totalCustomer = totalCustomer;
        customers = new Customer[totalCustomer];//不懂
    }

    /**
     * @Description 用途：将参数customer添加到数组中最后一个客户对象记录之后
     * @param customer 指定要添加的客户对象
     * @return添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer){
        if (total < customers.length){
            customers[total++] = customer;
            return true;
        }else{
            return false;
        }

    }

    /**
     * @Description 用途：用参数customer替换数组中由index指定的对象
     * @param index 指定所替换对象在数组中的位置，从0开始
     * @param cust 指定替换的新客户对象
     * @return 替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index, Customer cust){
        if (index <= total - 1){
            customers[index] = cust;
            return true;
        }else return false;
    }

    /**
     * @Description 从数组中删除参数index指定索引位置的客户对象记录
     * @param index 指定所删除对象在数组中的索引位置，从0开始
     * @return 删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index){
        if (index <= total - 1){
            customers[index] = null;
            for (int i = index; i <= total - 2 ; i++) {
                customers[i] = customers[i + 1];
            }
            total -=  1;
            customers[total] = null;
            return true;
        }else return false;
    }

    /**
     * @Description 返回数组中记录的所有客户对象
     * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     */
    public Customer[] getAllCustomers(){
        return customers;
    }

    /**
     * @Description 返回参数index指定索引位置的客户对象记录
     * @param index 指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index){
        return customers[index];
    }

    /**
     *
     * @return 返回已有的客户数
     */
    public int getTotal(){
        return total;
    }


}
