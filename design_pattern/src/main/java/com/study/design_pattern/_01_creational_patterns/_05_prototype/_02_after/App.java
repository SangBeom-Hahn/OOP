package com.study.design_pattern._01_creational_patterns._05_prototype._02_after;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("whiteship");
        repository.setName("live-study");
        
        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");
        
        String url = githubIssue.getUrl();
        System.out.println(url);
    
        GithubIssue githubIssue2 = (GithubIssue) githubIssue.clone();
        System.out.println(githubIssue2.getUrl());
    
        System.out.println(githubIssue != githubIssue2);
        System.out.println(githubIssue.equals(githubIssue2));
        System.out.println(githubIssue.getRepository() == githubIssue2.getRepository());
    }
}
