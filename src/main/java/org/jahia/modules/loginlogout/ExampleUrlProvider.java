package org.jahia.modules.loginlogout;

import org.jahia.bin.Logout;
import org.jahia.params.valves.LoginUrlProvider;
import org.jahia.params.valves.LogoutUrlProvider;
import org.jahia.settings.SettingsBean;
import org.jahia.utils.Url;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Small example on how to provide a login and logout URL provider from a module.
 */
public class ExampleUrlProvider implements LoginUrlProvider,LogoutUrlProvider {
    private static int count = 0;

    private String loginUrl;
    private String logoutUrl;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    @Override
    public String getLoginUrl(HttpServletRequest request) {
        return count++ > 0 ? getRedirectUrl(request) : null;
    }

    @Override
    public boolean hasCustomLoginUrl() {
        return true;
    }

    @Override
    public String getLogoutUrl(HttpServletRequest request) {
        return getRedirectUrlLogout(request);
    }

    @Override
    public boolean hasCustomLogoutUrl() {
        return true;
    }

    public String getRedirectUrl(HttpServletRequest request) {
        try {
            return getLoginUrl()
                    + "?service="
                    + URLEncoder.encode(getServiceUrl(request), SettingsBean
                    .getInstance().getCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String getRedirectUrlLogout(HttpServletRequest request) {
        try {
            return getLogoutUrl()
                    + "?service="
                    + URLEncoder.encode(
                    Url.getServer(request) + request.getContextPath()
                            + Logout.getLogoutServletPath(), SettingsBean.getInstance()
                            .getCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }


    private String getServiceUrl(HttpServletRequest request) {
        String originalUrl = (String) request
                .getAttribute("javax.servlet.error.request_uri");
        if (originalUrl == null) {
            originalUrl = request.getRequestURI();
        }
        return Url.getServer(request) + originalUrl;
    }

}