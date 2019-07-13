package com.book.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class OauthClientDetails implements Serializable {
    private String clientId;

    private Integer accessTokenValidity;

    private String additionalInformation;

    private String authorities;

    private String authorizedGrantTypes;

    private String autoapprove;

    private String clientSecret;

    private Integer refreshTokenValidity;

    private String resourceIds;

    private String scope;

    private String webServerRedirectUri;

    private static final long serialVersionUID = 1L;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clientId=").append(clientId);
        sb.append(", accessTokenValidity=").append(accessTokenValidity);
        sb.append(", additionalInformation=").append(additionalInformation);
        sb.append(", authorities=").append(authorities);
        sb.append(", authorizedGrantTypes=").append(authorizedGrantTypes);
        sb.append(", autoapprove=").append(autoapprove);
        sb.append(", clientSecret=").append(clientSecret);
        sb.append(", refreshTokenValidity=").append(refreshTokenValidity);
        sb.append(", resourceIds=").append(resourceIds);
        sb.append(", scope=").append(scope);
        sb.append(", webServerRedirectUri=").append(webServerRedirectUri);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}