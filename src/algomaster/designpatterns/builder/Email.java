package algomaster.designpatterns.builder;

public class Email {
    private final String to;
    private final String subject;
    private final String cc;
    private final String bcc;
    private final String body;
    private final String priority;
    private final String attachment;

    public String toString() {
        return to + " " + subject + " " + cc + " " + bcc + " " + body + " " + priority + " " + attachment;
    }

    public static class EmailBuilder {
        private String to;
        private String subject;
        private String cc;
        private String bcc;
        private String body;
        private String priority = "normal";
        private String attachment;

        public EmailBuilder(String to, String subject) {
            this.to = to;
            this.subject = subject;
        }

        public EmailBuilder cc(String cc) {
            if (this.cc != null)
                this.cc += " " + cc;
            else
                this.cc = cc;
            return this;
        }

        public EmailBuilder bcc(String bcc) {
            if (this.bcc != null)
                this.bcc += " " + bcc;
            else
                this.bcc = bcc;
            return this;
        }

        public EmailBuilder attachment(String attachment) {
            if (this.attachment != null)
                this.attachment += " " + attachment;
            else
                this.attachment = attachment;
            return this;
        }

        public EmailBuilder body(String body) {
            this.body = body;
            return this;
        }

        public EmailBuilder priority(String priority) {
            this.priority = priority;
            return this;
        }

        public Email build() {
            return new Email(this);
        }

    }

    private Email(EmailBuilder builder) {
        this.to = builder.to;
        this.subject = builder.subject;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.attachment = builder.attachment;
        this.priority = builder.priority;
        this.body = builder.body;
    };

    public static void main(String[] args) {
        Email email1 = new Email.EmailBuilder("alice@example.com", "Meeting Tomorrow")
                .body("Let's meet at 10am in conference room B.")
                .build();

        Email email2 = new Email.EmailBuilder("bob@example.com", "Project Update")
                .cc("carol@example.com")
                .cc("dave@example.com")
                .bcc("manager@example.com")
                .body("Attached is the Q4 report.")
                .priority("high")
                .attachment("q4-report.pdf")
                .attachment("summary.xlsx")
                .build();

        System.out.println(email1);
        System.out.println();
        System.out.println(email2);
    }

}
