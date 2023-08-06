package homework20.homework20.Service.impl;

import homework20.homework20.Exception.InvalidEmployeeDataExpetion;
import homework20.homework20.Service.EmployeeValidationServece;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static org.apache.tomcat.util.http.parser.HttpParser.isAlpha;

@Service
public class EmployeeValidationServaceImpl implements EmployeeValidationServece {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (!isAlpha(Integer.parseInt(name))) {
            throw new InvalidEmployeeDataExpetion("Не корректное значение имени " + name);
        }


    }
}
