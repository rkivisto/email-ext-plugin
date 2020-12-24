package hudson.plugins.emailext.groovy.sandbox;

import edu.umd.cs.findbugs.annotations.NonNull;
import javax.mail.internet.MimeMessage;
import java.lang.reflect.Method;

/**
 * {@link org.jenkinsci.plugins.scriptsecurity.sandbox.Whitelist} of explicit {@link MimeMessage} instances.
 */
public class MimeMessageInstanceWhitelist extends ObjectInstanceWhitelist<MimeMessage> {

    public MimeMessageInstanceWhitelist(@NonNull MimeMessage instance) {
        super(instance);
    }

    @Override
    public boolean permitsMethod(@NonNull Method method, @NonNull Object receiver, @NonNull Object[] args) {
        if (permitsInstance(receiver) && isClass(method.getDeclaringClass())) {
            String name = method.getName();
            return name.startsWith("get") || name.startsWith("set") || name.startsWith("add");
        }
        return false;
    }
}
