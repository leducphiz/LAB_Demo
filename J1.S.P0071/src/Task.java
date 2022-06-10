

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PhiLe
 */
public class Task {

    private int ID;
    private String TaskTypeID, Name, Assignee, Reviewer, Date;
    private double PlanFrom, PlanTo;

    public Task() {
    }

    public Task(int ID, String Name, String TaskTypeID, String Date, double PlanFrom, double PlanTo, String Assignee, String Reviewer) {
        this.ID = ID;
        this.TaskTypeID = TaskTypeID;
        this.Name = Name;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
        this.Date = Date;
        this.PlanFrom = PlanFrom;
        this.PlanTo = PlanTo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(String TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public double getPlanFrom() {
        return PlanFrom;
    }

    public void setPlanFrom(double PlanFrom) {
        this.PlanFrom = PlanFrom;
    }

    public double getPlanTo() {
        return PlanTo;
    }

    public void setPlanTo(double PlanTo) {
        this.PlanTo = PlanTo;
    }

    public double getTime() {
        return this.PlanTo - this.PlanFrom;
    }

}
