package org.xgun.kissolive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.xgun.kissolive.common.ServerResponse;
import org.xgun.kissolive.dao.GinaMapper;
import org.xgun.kissolive.pojo.*;
import org.xgun.kissolive.service.IGinaService;

import java.util.ArrayList;
import java.util.List;

@Service("iGinaService")
public class GinaServiceImpl implements IGinaService {

    @Autowired
    private GinaMapper ginaMapper;

// 学期
    @Override
    public ServerResponse<Boolean> addManager(Manager manager) {
        Boolean result = ginaMapper.insertManager(manager) > 0 ? true : false;
        // 如果在这个方法中发生了回滚，判断是否回滚，并向上一级输出提示信息
        if (TransactionAspectSupport.currentTransactionStatus().isRollbackOnly())
            return ServerResponse.createByErrorMessage("添加管理员失败,添加过程出错");
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse<Manager> managerLogin(Manager manager) {
        manager = ginaMapper.selectManagerByMnoAndMpwd(manager);
        if (manager != null)
            return ServerResponse.createBySuccess("登录成功！", manager);
        else
            return ServerResponse.createByErrorMessage("账号或密码错误！");
    }

    @Override
    public  ServerResponse<Teacher> teacherLogin(Teacher teacher) {
        teacher = ginaMapper.selectTeacherByTnoAndTpwd(teacher);
        if(teacher != null)
            return ServerResponse.createBySuccess("登录成功！", teacher);
        else
            return ServerResponse.createByErrorMessage("账号或密码错误！");
    }

    @Override
    public ServerResponse<Student> studentLogin(Student student) {
        student = ginaMapper.selectStudentBySnoAndSpwd(student);
        if(student != null)
            return ServerResponse.createBySuccess("登陆成功！", student);
        else
            return ServerResponse.createByErrorMessage("账号或密码错误！");
    }

    @Override
    @Transactional
    public ServerResponse<Boolean> addTermMeassage(Term term) {
        Boolean isExist = ginaMapper.selectTermCountByTermno(term.getTermno()) > 0 ? true : false;
        if (isExist)
            return ServerResponse.createByErrorMessage("添加学期失败,学期编号已经存在");
        Boolean result = ginaMapper.insertTermMessage(term) > 0 ? true : false;
        // 如果在这个方法中发生了回滚，判断是否回滚，并向上一级输出提示信息
        if (TransactionAspectSupport.currentTransactionStatus().isRollbackOnly())
            return ServerResponse.createByErrorMessage("添加学期失败,添加过程出错");
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse getTermList() {
        List<Term> list = ginaMapper.selectAllTerm();
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse deleteTerm(String termno) {
        Boolean result = ginaMapper.deleteTerm(termno) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse editTerm(Term term) {
        Boolean result = ginaMapper.updateTerm(term) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }
    // 学期

    // 院系
    @Override
    @Transactional
    public ServerResponse<Boolean> addDepartment(Department department) {
        Boolean isExit = ginaMapper.selectDepartmentCountByDno(department.getDno()) > 0 ? true : false;
        if (isExit)
            return ServerResponse.createByErrorMessage("添加院系信息失败，该院系编号已经存在");
        Boolean result = ginaMapper.insertDepartment(department) > 0 ? true : false;
        // 如果在这个方法中发生了回滚，判断是否回滚，并向上一级输出提示信息
        if (TransactionAspectSupport.currentTransactionStatus().isRollbackOnly())
            return ServerResponse.createByErrorMessage("添加院系信息失败,添加过程出错");
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse getDepartmentList(){
        List<Department> list = ginaMapper.selectAllDepartment();
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse deleteDepartment(String dno){
        Boolean result = ginaMapper.deleteDepqrtment(dno) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse editDepartment(Department department){
        Boolean result = ginaMapper.updateDepartment(department) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }
    // 院系


    // 老师
    @Override
    @Transactional
    public ServerResponse<Boolean> addTeacher(Teacher teacher){
        Boolean isExit = ginaMapper.selectTeacherCountByTno(teacher.getTno()) > 0 ? true : false;
        if(isExit)
            return ServerResponse.createByErrorMessage("添加教师信息失败，该教工号已经存在");
        Boolean result = ginaMapper.inserTeacher(teacher) > 0 ? true : false;
        // 如果在这个方法中发生了回滚，判断是否回滚，并向上一级输出提示信息
        if (TransactionAspectSupport.currentTransactionStatus().isRollbackOnly())
            return ServerResponse.createByErrorMessage("添加教师信息失败,添加过程出错");
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse getTeacherList(){
        List<Teacher> teachers = ginaMapper.selectAllTeacher();
        return ServerResponse.createBySuccess(teachers);
    }

    @Override
    public ServerResponse deleteTeacher(String tno){
        Boolean result = ginaMapper.deleteTeacher(tno) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public  ServerResponse editTeacher(Teacher teacher){
        Boolean result = ginaMapper.updateTeacher(teacher) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }
    // 老师


    //学生
    @Override
    @Transactional
    public ServerResponse<Boolean> addStudent(Student student){
        Boolean isExit = ginaMapper.selectStudentCountBySno(student.getSno()) > 0 ? true : false;
        if(isExit)
            return ServerResponse.createByErrorMessage("添加学生信息失败，该学号已经存在");
        Boolean result = ginaMapper.insertStudent(student) > 0 ? true : false;
        // 如果在这个方法中发生了回滚，判断是否回滚，并向上一级输出提示信息
        if (TransactionAspectSupport.currentTransactionStatus().isRollbackOnly())
            return ServerResponse.createByErrorMessage("添加学生信息失败,添加过程出错");
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse getStudentList(){
        List<Student> students = ginaMapper.selectAllStudent();
        return ServerResponse.createBySuccess(students);
    }

    @Override
    public ServerResponse deleteStudent(String sno) {
        Boolean result = ginaMapper.deleteStudent(sno) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse editStudent(Student student) {
        Boolean result = ginaMapper.updateStudent(student) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }
    //学生

    //消息
    @Override
    @Transactional
    public ServerResponse sentStartLseeonNotice(Message message){
        List<Teacher> teacherList = ginaMapper.selectAllTeacher();
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < teacherList.size(); i++) {
            Message msg = new Message(0,message.getTitle(),message.getContent(),teacherList.get(i).getTno());
            messageList.add(msg);
        }
        int i = ginaMapper.insertStartLseeonNotice(messageList);
        if(i > 0)
            return ServerResponse.createBySuccess();
        else
            return ServerResponse.createByErrorMessage("发送开课通知失败");
    }

    @Override
    public ServerResponse getTeacherMessage(String tno){
        List<Message> messageList = ginaMapper.getTeacherMessage(tno);
        return ServerResponse.createBySuccess(messageList);
    }

    @Override
    public ServerResponse classApplication(Course course){
        Boolean result = ginaMapper.insertStartClassApplication(course) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse getCourseList(){
        List<Course> courseList = ginaMapper.getCourseList();
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    @Transactional
    public ServerResponse sentElectiveNotice(Message message){
        List<Student> studentList = ginaMapper.selectAllStudent();
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            Message msg = new Message(0,message.getTitle(),message.getContent(),studentList.get(i).getSno());
            messageList.add(msg);
        }
        int i = ginaMapper.insertElectiveNotice(messageList);
        if(i > 0)
            return ServerResponse.createBySuccess();
        else
            return ServerResponse.createByErrorMessage("发送开课通知失败");
    }

    @Override
    public ServerResponse getStudentessage(String sno){
        List<Message> messageList = ginaMapper.getStudentMessage(sno);
        return ServerResponse.createBySuccess(messageList);
    }

    @Override
    public ServerResponse changeCourseStatus(Course course){
        Boolean result = ginaMapper.updateStatus(course) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse getAuditingCourseList(){
        List<Course> courseList = ginaMapper.getAuditingCourse();
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    public ServerResponse getNotAuditingCourseList(){
        List<Course> courseList = ginaMapper.getNotAuditingCourse();
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    @Transactional
    public ServerResponse addSelectCourse(Scort scort){
        Boolean isExist = ginaMapper.selectScortCountBySnoAndCno(scort.getSsno(),scort.getScno()) > 0 ? true : false;
        if (isExist){
            return ServerResponse.createByErrorMessage("选课失败,该课程已选择");
        }
        Boolean result = ginaMapper.insertSelectClass(scort) > 0 ? true : false;
        if (TransactionAspectSupport.currentTransactionStatus().isRollbackOnly())
            return ServerResponse.createByErrorMessage("选课失败,选课过程出错");
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse selectCourseIsSelected(String ssno){
        List<Scort> scortList = ginaMapper.selectCourseIsSelectedBySno(ssno);
        return ServerResponse.createBySuccess(scortList);
    }

    @Override
    public ServerResponse notSelectedCourse(String ssno){
        List<Course> courseList = ginaMapper.selectNotSelectedCourseBySno(ssno);
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    public ServerResponse withdrawalCourse(int sno){
        Boolean result = ginaMapper.deleteSelectedCourse(sno) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse addResnum(int sno,int cresnum){
        Boolean result = ginaMapper.updateResnumAdd(sno, cresnum) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse updateResnumReduce(int cno,int cresnum){
        Boolean result = ginaMapper.updateResnumReduce(cno, cresnum) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse courseSelection(){
        List<Course> courseList = ginaMapper.courseList();
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    public ServerResponse getStartCourseList(){
        List<Course> courseList = ginaMapper.getStartCourse();
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    public ServerResponse getNotStartCourseList(){
        List<Course> courseList = ginaMapper.getNotStartCourse();
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    public ServerResponse getCourseSituation(String ctno){
        List<Course> courseList = ginaMapper.getCourseSituation(ctno);
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    public ServerResponse getStartCourseByTeacher(String tno){
        List<Course> courseList = ginaMapper.getStartCourseByTno(tno);
        return ServerResponse.createBySuccess(courseList);
    }

    @Override
    public ServerResponse getStudentChooseCourse(int cno){
        List<Student> students = ginaMapper.getStudentChooseCourseByCnoAndSno(cno);
        return ServerResponse.createBySuccess(students);
    }

//    @Override
//    public ServerResponse entryGrade(String ssno, int scno, int grade){
//        Boolean result = ginaMapper.updateGrade(ssno,scno,grade) > 0 ? true : false;
//        return ServerResponse.createBySuccess(result);
//    }
//@Override
//@Transactional
//public ServerResponse sentStartLseeonNotice(Message message){
//    List<Teacher> teacherList = ginaMapper.selectAllTeacher();
//    List<Message> messageList = new ArrayList<>();
//    for (int i = 0; i < teacherList.size(); i++) {
//        Message msg = new Message(0,message.getTitle(),message.getContent(),teacherList.get(i).getTno());
//        messageList.add(msg);
//    }
//    int i = ginaMapper.insertStartLseeonNotice(messageList);
//    if(i > 0)
//        return ServerResponse.createBySuccess();
//    else
//        return ServerResponse.createByErrorMessage("发送开课通知失败");
//}

//    @Override
//    @Transactional
//    public ServerResponse entryGrade(Scort scort){
//        //获取选择某一课程的全部学生
//        List<Student> studentList = ginaMapper.getStudentChooseCourseByCnoAndSno(scort.getScno());
//        List<Scort> scortList = new ArrayList<>();
//        for (int i = 0; i < studentList.size(); i++) {
//            Scort scort1 = new Scort(studentList.get(i).getSno(),scort.getScno(),scort.getGrade(),scort.getStermno(),scort.getCname(),scort.getCcredit(),scort.getTname(),scort.getCresnum(),scort.getCdesc());
//            //Boolean result = ginaMapper.updateGrade(scort1) > 0 ? true : false;
//            scortList.add(scort1);
//        }
//    }

    @Override
    public ServerResponse changePasswordByAdmin(String mno, String mpwd){
        Boolean result = ginaMapper.updatePasswordByMno(mno,mpwd) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse changePasswordByTeacher(String tno,String tpwd){
        Boolean result = ginaMapper.updatePasswordByTno(tno,tpwd) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }

    @Override
    public ServerResponse changePasswordByStudent(String sno, String spwd){
        Boolean result = ginaMapper.updatePasswordBySno(sno, spwd) > 0 ? true : false;
        return ServerResponse.createBySuccess(result);
    }
}