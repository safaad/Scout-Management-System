package Model;

public class Message {
    private String from,to,subject;

    public Message(String from, String subject) {
        this.from = from;
        this.subject = subject;
    }
    public Message(String from, String to, String subject) {
        this.from = from;
        this.to = to;
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
