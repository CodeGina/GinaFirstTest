package org.xgun.kissolive.utils;

import org.xgun.kissolive.dao.GinaMapper;
import org.xgun.kissolive.pojo.Student;
import org.xgun.kissolive.pojo.Teacher;
import org.xgun.kissolive.service.impl.GinaServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class SetDataUtil {
    public List<Student> newStudent(String dno){
        List<Student> list = new ArrayList<>();
        for (int i = 1; i <= 99; i++) {
            String sno = "";
            if(i<10){
                sno = "2018"+dno+"000"+i;
            }else {
                sno = "2018"+dno+"00"+i;
            }
            String sex = getSex();
            String sname = getName(sex);
            String birth = getBirth();
            Student student = new Student(sno,sname,sex,birth,"123456",dno,null);
            list.add(student);
        }
        return list;
    }


    public int getNumber(int i){
        return (int)(1+Math.random()*i);
    }

    public String getName(String sex){
        //100
        String xingshi[] = {"李","王","张","刘","陈","杨","赵","黄","周","吴","徐","孙","胡","朱","高","林","何","郭","马","罗","梁","宋","郑","谢","韩","唐","冯","于","董","萧","程","曹","袁","邓","许","傅","沈","曾","彭","吕","苏","卢","蒋","蔡","贾","丁","魏","薛","叶","阎","余","潘","杜","戴","夏","钟","汪","田","任","姜","范","方","石","姚","谭","廖","邹","熊","金","陆","郝","孔","白","崔","康","毛","邱","秦","江","史","顾","侯","邵","孟","龙","万","段","漕","钱","汤","尹","黎","易","常","武","乔","贺","赖","龚","文"};
        //141
        String nvming[] = {"筠","柔","竹","霭","凝","晓","欢","霄","枫","芸","菲","寒","伊","亚","宜","可","姬","舒","影","荔","枝","思","丽","秀","娟","英","华","慧","巧","美","娜","静","淑","惠","珠","翠","雅","芝","玉","萍","红","娥","玲","芬","芳","燕","彩","春","菊","勤","珍","贞","莉","兰","凤","洁","梅","琳","素","云","莲","真","环","雪","荣","爱","妹","霞","香","月","莺","媛","莎","锦","黛","青","倩","婷","姣","婉","娴","瑾","颖","露","瑶","怡","婵","雁","蓓","纨","艳","瑞","凡","佳","嘉","琼","桂","娣","叶","璧","璐","娅","琦","晶","妍","茜","秋","珊","仪","荷","丹","蓉","眉","君","琴","蕊","薇","菁","梦","岚","韵","融","园","艺","咏","卿","聪","毓","悦","昭","冰","爽","琬","茗","羽","希","苑","婕","馨","瑗","琰"};
        //126
        String nanming[] = {"梁","栋","维","启","克","伦","翔","旭","鹏","泽","晨","辰","士","以","建","家","致","树","炎","盛","雄","琛","钧","冠","策","腾","楠","榕","风","航","弘","义","兴","良","飞","彬","富","鸣","朋","斌","行","时","泰","博","磊","民","友","志","清","坚","庆","若","德","彪","刚","勇","毅","俊","峰","强","军","平","保","东","文","辉","力","明","永","健","世","广","海","山","仁","波","宁","福","生","龙","元","全","国","胜","学","祥","才","发","武","新","利","顺","信","子","杰","涛","昌","成","康","星","光","天","达","安","岩","中","茂","进","有","诚","先","敬","震","振","壮","会","思","群","豪","心","邦","承","乐","绍","功","松"};
        if(sex.equals("男")){
            return xingshi[getNumber(100)-1]+nanming[getNumber(126)-1]+nanming[getNumber(126)-1];
        }else {
            return xingshi[getNumber(100)-1]+nvming[getNumber(141)-1]+nvming[getNumber(141)-1];
        }
    }


    public String getSex(){
        return getNumber(2)%2==0?"男":"女";
    }


    public String getBirth(){
        int m = getNumber(12);
        String month = "";
        if(m<10){
            month = "0"+m;
        }else {
            month = m+"";
        }
        int d = getNumber(28);
        String day = "";
        if(d<10) {
            day = "0" + d;
        }else {
            day = d+"";
        }
        return ""+(1996+getNumber(3))+"-"+month+"-"+day;
    }

    public String getTBirth(){
        int m = getNumber(12);
        String month = "";
        if(m<10){
            month = "0"+m;
        }else {
            month = m+"";
        }
        int d = getNumber(28);
        String day = "";
        if(d<10) {
            day = "0" + d;
        }else {
            day = d+"";
        }
        return ""+(1960+getNumber(22))+"-"+month+"-"+day;
    }


    public List<Teacher> newTeacher(){
        List<Teacher> list = new ArrayList<>();
        for (int i = 1; i <= 99; i++) {
            String tno = "";
            if(i<10){
                tno = "000"+i;
            }else {
                tno = "00"+i;
            }
            String sex = getSex();
            String tname = getName(sex);
            String birth = getTBirth();
            String zhicheng[] = getXueLiZhiCheng();
            String teducation = zhicheng[0];
            String tposition = zhicheng[1];
            String jianjie = getJianJie();
            Teacher teacher = new Teacher(tno,tname,sex,birth,teducation,tposition,jianjie,null);
            list.add(teacher);
        }
        return list;
    }

    public String[] getXueLiZhiCheng(){
        String zhujiao[] = {"助教","硕士"};
        String jiangshi[] = {"讲师","硕士"};
        String fujiaoshou[] = {"副教授","博士"};
        String jiaoshou[] = {"教授","博士"};
        int i = getNumber(4);
        switch (i){
            case 1 :return zhujiao;
            case 2 :return jiangshi;
            case 3 :return fujiaoshou;
            case 4 :return jiaoshou;
            default:return null;
        }
    }

    public String getJianJie(){
        String j1 = "每节课都要点名的噢";
        String j2 = "我的课很有趣噢";
        String j3 = "期末要交小论文，请三思";
        String j4 = "我不会讲普通话";
        String j5 = "我很帅，但是我更温柔";
        String j6 = "我用飘柔的";
        String j7 = "大家一起来修仙";
        String j8 = "这个老师很懒，什么也没留下";
        int i = getNumber(8);
        switch (i){
            case 1 :return j1;
            case 2 :return j2;
            case 3 :return j3;
            case 4 :return j4;
            case 5 :return j5;
            case 6 :return j6;
            case 7 :return j7;
            case 8 :return j8;
            default:return null;
        }
    }

}
