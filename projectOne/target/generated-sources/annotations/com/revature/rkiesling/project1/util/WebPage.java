package com.revature.rkiesling.project1.util;

public interface WebPage {
        
    String adminInputSize = "\"50\"";
    String roleSelectSize = "\"35\"";
    String adminFormInputPad = "p-2";

    // The portion of the heading before the user-defined title
    static String heading1 = 
        "<!DOCTYPE html><html lang=\"en\"><head>\n" 
        + "<meta charser=\"utf-8\">\n"
        + "<meta name=\"viewport\" content=\"width=device-width, inititial-scale=1\">\n"
        + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">"
        + "<title>";

    static String addUserForm =
        "<div class=\"d-grid gap-3 p-2 border border-dark bg-primary text-gray\">" 
          + "<form action=\"AddEmployee\" method=\"GET\">"
            + "<h6>Add a user:</h6>"
            + "<div class=\"form-group mx-auto " + adminFormInputPad + "\">"
              + "<input placeholder=\"First Name\" size=" + adminInputSize + "class=\"form-control\" name=\"firstname\" id=\"firstname\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + adminFormInputPad + "\">"
              + "<input placeholder=\"Last Name\" size=" + adminInputSize + "class=\"form-control\" name=\"lastname\" id=\"lastname\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + adminFormInputPad + "\">"
              + "<input placeholder=\"SSN (xxx-xx-xxxx)\" size=" + adminInputSize + "class=\"form-control\" name=\"ssn\" id=\"ssn\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + adminFormInputPad + "\">"
              + "<input placeholder=\"User ID\" size=" + adminInputSize + "class=\"form-control\" name=\"userid\" id=\"userid\">"
            + "<div class=\"form-group mx-auto " + adminFormInputPad + "\">"
              + "<input placeholder=\"Password\" type=\"password\" size=" + adminInputSize + "class=\"form-control\" name=\"password\" id=\"password\">"
            + "</div>"
            + "<br>"
            + "<div class=\"d-grid gap-3 " + adminFormInputPad + "\">"
              + "<div class=\"border border-dark\">"
                  + "<div class=\"" + adminFormInputPad + "\">"
                    + "<label for=\"role\" class=\"" + adminFormInputPad + "\">Role...</label>"
                    + "<select placeholder=\"Role...\" class=\"custom-select\" name=\"role\" id=\"role\" multiple>"
                      + "<option value=\"admin\">Admin</option>"
                      + "<option value=\"employee\">Employee</option>"
                      + "<option value=\"Manager\">Manager</option>"
                    + "</select>"
                  + "</div>"
              + "</div>"

              + "<div width=\"50%\" class=\"border border-dark " + adminFormInputPad + "\">"
                + "<button type=\"submit\">Add User</button>"
              + "</div>"
            + "</div>"
          + "</form>"
        + "</div>";
    

    // Refer to the bootstrap documentation, https://getbootstrap.com,
    // for its bgStyle and textColor definitions.
    public static String pageHeadingInternal (String title, String bgStyle,
                                              String textColor) {
        String headingString = heading1;
        headingString += title;
        headingString += "</title></head><body class=\"p-3 mb-2 ";
        headingString += bgStyle + " " + textColor + "\">";
        return headingString;
    }
    public static String pageHeading (String title) {
        return pageHeadingInternal (title, "bg-secondary", "text-white");
    }
    public static String errorPageHeading (String title) {
        return pageHeadingInternal (title, "bg-info", "text-black");
    }
    
    public static String pageFooting () {
        String footingString ="<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" crossorigin=\"anonymous\"></script>";

        footingString += "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js\" integrity=\"sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi\" crossorigin=\"anonymous\"></script>";
        footingString += "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js\" integrity=\"sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG\" crossorigin=\"anonymous\"></script>";
        footingString += "</body></html>";
        return footingString;
    }
}
