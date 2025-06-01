package co.edu.uco.asistenciauco.infrastructure.secondaryadaptersJ.info;

import co.edu.uco.crosscutting.helpers.TextHelper;

public class EmailMessage {

    private String to;
    private String subject;
    private String content;

    private EmailMessage(final String to, final String subject, final String content) {
        setTo(to);
        setSubject(subject);
        setContent(content);
    }

    public static EmailMessage create(final String to) {
        return new EmailMessage(to, TextHelper.EMPTY, TextHelper.EMPTY);
    }

    public static EmailMessage create(final String to, final String subject) {
        return new EmailMessage(to, subject, TextHelper.EMPTY);
    }

    public static EmailMessage create(final String to, final String subject, final String content) {
        return new EmailMessage(to, subject, content);
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = TextHelper.applyTrim(to);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = TextHelper.applyTrim(subject);
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = TextHelper.applyTrim(content);
    }

}
