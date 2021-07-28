package p2.ui;

import p2.bean.Customer;
import p2.service.CustomerList;
import p2.util.CMUtility;

import java.util.Scanner;

/**
 * @Author reguozhi
 * @Date 2021年7月27日
 * @Description CustomerView为主模块，负责菜单的显示和处理用户操作
 * @Since version-1.0
 */


public class CustomerView {
    CustomerList customerList = new CustomerList(10);



    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();

    }

    /**
     * 用途：显示主菜单，响应用户输入，
     * 根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理。
     */
    public void enterMainMenu() {
        while (true){
            System.out.print("-----------------客户信息管理软件-----------------\n\n");
            System.out.print("\t\t\t\t1 添 加 客 户\t\n");
            System.out.print("\t\t\t\t2 修 改 客 户\t\n");
            System.out.print("\t\t\t\t3 删 除 客 户\t\n");
            System.out.print("\t\t\t\t4 客 户 列 表\t\n");
            System.out.print("\t\t\t\t5 退       出\t\n\n");
            System.out.print("\t\t\t\t请选择(1-5)：_\t");

            char choose = CMUtility.readMenuSelection();
            switch (choose){
                case '1':addNewCustomer();break;
                case '2':modifyCustomer();break;
                case '3':deleteCustomer();break;
                case '4':listAllCustomers();break;
                case '5':return;
            }
        }
    }

    /**
     * 用途：这四个方法分别完成“添加客户”、“修改客户”、“删除客户”和“客户列表”
     * 等各菜单功能。
     * 这四个方法仅供enterMainMenu()方法调用。
     */
    private void addNewCustomer() {
        Customer cus = new Customer();
        System.out.println("\n---------------------添加客户---------------------");

        System.out.print("姓名：");
        cus.setName(CMUtility.readString(10));

        System.out.print("性别：");
        cus.setGender(CMUtility.readChar());

        System.out.print("年龄：");
        cus.setAge(CMUtility.readInt());

        System.out.print("电话：");
        cus.setPhone(CMUtility.readString(20));

        System.out.print("邮箱：");
        cus.setEmail(CMUtility.readString(30));


        customerList.addCustomer(cus);

        System.out.println("---------------------添加完成---------------------");


    }

    private void modifyCustomer() {
        System.out.println("\n---------------------修改客户---------------------");

        System.out.print("请选择待修改客户编号(-1退出):");
        int cusNum = CMUtility.readInt() - 1;//cusNum代表索引值，从0开始
        if (cusNum == -1)return;
        //输出姓名并修改
        System.out.printf("姓名（%s）:", customerList.getCustomer(cusNum).getName());
        String newName = CMUtility.readString(10,customerList.getCustomer(cusNum).getName());
        if (newName.equals(customerList.getCustomer(cusNum).getName())){
        }else{

            customerList.getCustomer(cusNum).setName(newName);
        }
        //输出性别并修改
        System.out.printf("性别（%c）:", customerList.getCustomer(cusNum).getGender());
        char newGender = CMUtility.readChar(customerList.getCustomer(cusNum).getGender());
        if (newGender == customerList.getCustomer(cusNum).getGender()){

        }else{

            customerList.getCustomer(cusNum).setGender(newGender);
        }

        System.out.printf("年龄（%d）:", customerList.getCustomer(cusNum).getAge());
        int newAge = CMUtility.readInt(customerList.getCustomer(cusNum).getAge());
        if (newAge == customerList.getCustomer(cusNum).getAge()){

        }else{

            customerList.getCustomer(cusNum).setAge(newAge);
        }
        //输出电话并修改
        System.out.printf("电话（%s）:", customerList.getCustomer(cusNum).getPhone());
        String newPhone = CMUtility.readString(20,customerList.getCustomer(cusNum).getPhone());
        if (newPhone.equals(customerList.getCustomer(cusNum).getPhone())){
        }else{

            customerList.getCustomer(cusNum).setPhone(newPhone);
        }

        //输出邮箱并修改
        System.out.printf("邮箱（%s）:", customerList.getCustomer(cusNum).getEmail());
        String newEmail = CMUtility.readString(20,customerList.getCustomer(cusNum).getEmail());
        if (newEmail.equals(customerList.getCustomer(cusNum).getEmail())){
        }else{
            customerList.getCustomer(cusNum).setEmail(newEmail);
        }

        System.out.println("---------------------修改完成---------------------");
    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        System.out.print("请选择待修改客户编号(-1退出):");
        int cusNum = CMUtility.readInt();
        if (cusNum == -1)return;
        System.out.println(cusNum);
        customerList.deleteCustomer(cusNum);
        System.out.println("---------------------删除完成---------------------");

    }

    private void listAllCustomers() {
        System.out.println("---------------------客户列表---------------------");
        System.out.printf("编号\t姓  名\t性别\t年龄\t电话\t\t邮箱\n");
        for (int i = 0; i < customerList.getTotal(); i++) {
            System.out.printf("%2d\t\t%s\t%c\t\t%2d\t%s\t%s\n",//听课时学习一下怎么对齐
                    i+1, customerList.getCustomer(i).getName(), customerList.getCustomer(i).getGender(),
                    customerList.getCustomer(i).getAge(), customerList.getCustomer(i).getPhone(),
                    customerList.getCustomer(i).getEmail());
        }
        System.out.println("---------------------客户列表完成---------------------");
    }


}
