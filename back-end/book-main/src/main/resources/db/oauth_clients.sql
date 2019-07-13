create table oauth_client_details
(
    client_id               varchar(255) not null primary key,
    access_token_validity   int          null,
    additional_information  varchar(255) null,
    authorities             varchar(255) null,
    authorized_grant_types  varchar(255) null,
    autoapprove             varchar(255) null,
    client_secret           varchar(255) null,
    refresh_token_validity  int          null,
    resource_ids            varchar(255) null,
    scope                   varchar(255) null,
    web_server_redirect_uri varchar(255) null
);
insert into `oauth_client_details`
VALUES ('client', NULL, NULL, NULL, 'password,authorization_code,refresh_token', NULL, 'secret', NULL, NULL,
        'all', NULL);
insert into `oauth_client_details`
VALUES ('app', NULL, NULL, NULL, 'authorization_code', NULL, 'app', NULL, NULL, 'all', NULL);
