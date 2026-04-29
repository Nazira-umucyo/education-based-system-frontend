package com.nelly.education_based;

import com.nelly.education_based.services.CourseService;
import com.nelly.education_based.services.EnrollmentService;
import com.nelly.education_based.services.StudentService;
import com.nelly.education_based.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private static Stage primaryStage;
    private static StudentService   studentService;
    private static CourseService    courseService;
    private static EnrollmentService enrollmentService;
    private static UserService      userService;

    @Override
    public void start(Stage stage) {
        primaryStage       = stage;
        studentService     = new StudentService();
        courseService      = new CourseService();
        enrollmentService  = new EnrollmentService(studentService, courseService);
        userService        = new UserService();
        showLoginView();
    }

    public static void showLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
            Scene scene = new Scene(loader.load(), 420, 520);
            primaryStage.setTitle("University Management System - Login");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load login-view.fxml", e);
        }
    }

    public static void showMainView() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
            Scene scene = new Scene(loader.load(), 960, 700);
            primaryStage.setTitle("University Management System");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load main-view.fxml", e);
        }
    }

    public static StudentService    getStudentService()    { return studentService; }
    public static CourseService     getCourseService()     { return courseService; }
    public static EnrollmentService getEnrollmentService() { return enrollmentService; }
    public static UserService       getUserService()       { return userService; }

    public static void main(String[] args) {
        launch();
    }
}