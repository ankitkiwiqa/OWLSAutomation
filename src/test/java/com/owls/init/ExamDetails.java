package com.owls.init;

import java.util.ArrayList;


public class ExamDetails {

	public static String ExamPaperName="";
	public static String ExamName="";
	
	public static String SessionName="";
	public static String InvigilatorName="";
	public static String ExamCapacity="";
	public static String TestCenterName;
	public static String reviewRequestComment="";
	
	public static String markingplanName;
	public static ArrayList<ArrayList<String>> markerReviewer = new ArrayList<ArrayList<String>>();
	
	public static ArrayList<String> markerReviewerstaff = new ArrayList<String>();
	
	public static ArrayList<String> comments = new ArrayList<String>();  
	
	public static ArrayList<String> QuestionList = new ArrayList<String>();  
	
	
	
	public static ArrayList<String> getQuestionList() {
		return QuestionList;
	}

	public static void setQuestionList(ArrayList<String> questionList) {
		QuestionList = questionList;
	}
	public static void addQuestion(String Que)
	{
		QuestionList.add(Que);
	}

	public static String getMarkingplanName() {
		return markingplanName;
	}

	public static void AddComment(String Comment)
	{
		comments.add(Comment);
	}
	
	public static ArrayList<String> getMarkerReviewerstaff() {
		return markerReviewerstaff;
	}

	public static void setMarkerReviewerstaff(ArrayList<String> markerReviewerstaff) {
		ExamDetails.markerReviewerstaff = markerReviewerstaff;
	}

	
	public static void AddMarkerReviewerstaff(String staffName,String role) {
		ExamDetails.markerReviewerstaff.add(staffName);
		ExamDetails.markerReviewerstaff.add(role);
		markerReviewer.add(markerReviewerstaff);
		markerReviewerstaff = new ArrayList<String>();
	}
	
	public static void getMarkerReviewerstaffwithRole() {
		
	}
	

	public static void setMarkingplanName(String markingplanName) {
		ExamDetails.markingplanName = markingplanName;
	}

	

	public static ArrayList<ArrayList<String>> getMarkerReviewer() {
		return markerReviewer;
	}

	public static void setMarkerReviewer(ArrayList<ArrayList<String>> markerReviewer) {
		ExamDetails.markerReviewer = markerReviewer;
	}



	public static ArrayList<String> candidateNames = new ArrayList<String>();
	
	public static String getTestCenterName() {
		return TestCenterName;
	}
	
	public static ArrayList<String> getCandidateNames() {
		return candidateNames;
	}
	
	public static void setCandidateNames(ArrayList<String> candidateNames1) {
		candidateNames = candidateNames1;
	}
	
	public static void setTestCenterName(String testCenterName) {
		TestCenterName = testCenterName;
	}
	
	public static String getExamCapacity() {
		return ExamCapacity;
	}
	
	public static void setExamCapacity(String examCapacity) {
		ExamCapacity = examCapacity;
	}
	
	public static String getExamPaperName() {
		return ExamPaperName;
	}
	
	public static void setExamPaperName(String examPaperName) {
		ExamPaperName = examPaperName;
	}
	
	public static String getExamName() {
		return ExamName;
	}
	
	public static void setExamName(String examName) {
		ExamName = examName;
	}
	
	public static String getSessionName() {
		return SessionName;
	}
	
	public static void setSessionName(String sessionName) {
		SessionName = sessionName;
	}
	
	public static String getInvigilatorName() {
		return InvigilatorName;
	}
	
	public static void setInvigilatorName(String invigilatorName) {
		InvigilatorName = invigilatorName;
	}
	
	public static String MarkerComment="";
	
	public static String ReviewerComment="";

	public static String getMarkerComment() {
		return MarkerComment;
	}

	public static String getReviewerComment() {
		return ReviewerComment;
	}

	public static void setReviewerComment(String reviewerComment) {
		ReviewerComment = reviewerComment;
	}

	public static void setMarkerComment(String markerComment) {
		MarkerComment = markerComment;
	}
	
	public static String getReviewRequestComment() {
		return reviewRequestComment;
	}

	public static void setReviewRequestComment(String reviewRequestComment) {
		ExamDetails.reviewRequestComment = reviewRequestComment;
	}



	public static ArrayList<ArrayList<Integer>> MarkedAnswerByMarker = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<Integer> Answers = new ArrayList<Integer>(); 
	

	public static ArrayList<ArrayList<Integer>> getMarkedAnswerByMarker() {
		return MarkedAnswerByMarker;
	}

	public static void setMarkedAnswerByMarker(ArrayList<ArrayList<Integer>> markedAnswerByMarker) {
		MarkedAnswerByMarker = markedAnswerByMarker;
	}

	public static void addAnswers(Integer AnswerList) {
		Answers.add(AnswerList);
	}

	public static void AddAnswerMarkedByMarker(ArrayList<Integer> answersList) {
		
		MarkedAnswerByMarker.add(answersList);
		Answers = new ArrayList<Integer>();
	}
	
	public static String markerFeedback="";
	 
	 public static String getMarkerFeedback() {
	  return markerFeedback;
	 }

	 public static void setMarkerFeedback(String markerFeedback) {
	  ExamDetails.markerFeedback = markerFeedback;
	 }
	
	 public static String reviewerFeedBack="";

	 public static String getReviewerFeedBack() {
	  return reviewerFeedBack;
	 }
	 
	 public static void setReviewerFeedBack(String reviewerFeedBack) {
		  ExamDetails.reviewerFeedBack = reviewerFeedBack;
		 }
}
