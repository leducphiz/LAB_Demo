package j1.s.p0071;

import java.util.Date;

public class Task {
    private int ID;
    private int taskID;
    private Date date;
    private String requirementName;
    private String assignee;
    private float planFrom;
    private float planTo;
    private String reviewer;

    public Task() {
    }

    public Task(int ID, int taskID, Date date, String requirementName, String assignee, float planFrom, float planTo, String reviewer) {
        this.ID = ID;
        this.taskID = taskID;
        this.date = date;
        this.requirementName = requirementName;
        this.assignee = assignee;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.reviewer = reviewer;
    }

    public int getID() {
        return ID;
    }

    public int getTaskID() {
        return taskID;
    }

    public Date getDate() {
        return date;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public String getAssignee() {
        return assignee;
    }

    public float getPlanFrom() {
        return planFrom;
    }

    public float getPlanTo() {
        return planTo;
    }

    public String getReviewer() {
        return reviewer;
    }

}
