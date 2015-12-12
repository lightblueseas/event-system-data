
    create table addresses (
        id int4 not null,
        address_comment varchar(100),
        geohash varchar(16),
        latitude varchar(12),
        longitude varchar(12),
        street varchar(64),
        streetnumber varchar(5),
        federalstate_id int4,
        zipcode_id int4,
        primary key (id)
    );
create table appointments (
        id int4 not null,
        endtime timestamp,
        nexttime timestamp,
        rhythm varchar(255),
        starttime timestamp,
        primary key (id)
    );
create table blacklisted_contacts (
        user_data_id int4 not null,
        blacklisted_id int4 not null,
        primary key (user_data_id, blacklisted_id)
    );
create table categories (
        id int4 not null,
        name varchar(40),
        primary key (id)
    );
create table contactmethods (
        id int4 not null,
        contactmethod varchar(255),
        contactvalue varchar(1024),
        primary key (id)
    );
create table countries (
        id int4 not null,
        iso3166_a2name varchar(2),
        iso3166_a3name varchar(3),
        iso3166_number varchar(3),
        name varchar(128),
        primary key (id)
    );
create table event_location_data (
        id int4 not null,
        available_rooms int4,
        catering_abilities int4,
        near_by_restaurant int4,
        offered_evening bool,
        offered_weekdays bool,
        offered_weekend bool,
        parking_abilities int4,
        roomtype varchar(256),
        seats_per_room int4,
        primary key (id)
    );
create table event_locations (
        id int4 not null,
        appointment_id int4,
        contactperson_id int4,
        event_id int4,
        event_location_id int4,
        primary key (id)
    );
create table event_messages (
        id int4 not null,
        event_location_id int4,
        message_id int4,
        primary key (id)
    );
create table event_ratings (
        id int4 not null,
        rating_date timestamp,
        rating_description varchar(1024),
        rating_points int4,
        title_rating varchar(256),
        visibility varchar(255),
        contact int4,
        eventlocation int4,
        material int4,
        presentation int4,
        support int4,
        topic int4,
        rater int4,
        event_id int4,
        primary key (id)
    );
create table event_topics (
        id int4 not null,
        event_id int4,
        topic_id int4,
        primary key (id)
    );
create table events (
        id int4 not null,
        consultant varchar(64),
        content varchar(21845),
        difficulty varchar(255),
        duration int4,
        eventtype varchar(255),
        head varchar(21845),
        introduction varchar(21845),
        locale varchar(64),
        material bool,
        name varchar(64),
        price numeric(19, 2),
        provider bytea,
        requirements varchar(21845),
        subscribermax int4,
        subscribermin int4,
        targetgroup varchar(21845),
        categories_id int4,
        primary key (id)
    );
create table federalstates (
        id int4 not null,
        iso3166_a2code varchar(6),
        name varchar(128),
        subdivision_category varchar(128),
        subdivision_name varchar(56),
        country_id int4,
        primary key (id)
    );
create table message_attachments (
        message_id int4 not null,
        resource_id int4 not null,
        primary key (message_id, resource_id)
    );
create table message_recipients (
        id int4 not null,
        message_id int4,
        recipient_id int4,
        recipient_email int4,
        primary key (id)
    );
create table messages (
        id int4 not null,
        failed2sentemail bool,
        folder varchar(64),
        messageContent varchar(21845),
        messagetype varchar(255),
        read_flag bool,
        recipient_deleted_flag bool,
        sender_deleted_flag bool,
        sent_date timestamp,
        spam_flag bool,
        state varchar(255),
        subject varchar(1000),
        parent int4,
        sender int4,
        sender_email int4,
        primary key (id)
    );
create table offered_event_locations (
        id int4 not null,
        location_description varchar(21845),
        location_equipment_description varchar(21845),
        offered_from_description varchar(21845),
        support_description varchar(21845),
        user_id int4,
        event_location_data_id int4,
        provider_id int4,
        user_address_id int4,
        primary key (id)
    );
create table permissions (
        id int4 not null,
        description varchar(64),
        permissionName varchar(64) unique,
        shortcut varchar(10) unique,
        primary key (id)
    );
create table profile_federalstates (
        id int4 not null,
        federalstate_id int4,
        user_id int4,
        primary key (id)
    );
create table profile_topics (
        id int4 not null,
        topic_id int4,
        user_id int4,
        primary key (id)
    );
create table rating_descriptions (
        id int4 not null,
        less_like_rating varchar(1024),
        most_like_rating varchar(1024),
        recommend_consultant varchar(1024),
        recommend_event varchar(1024),
        event_ratings_id int4,
        primary key (id)
    );
create table recommendations (
        id int4 not null,
        email varchar(1024),
        invitation_text varchar(1024),
        sent bool,
        recommended_id int4,
        user_id int4,
        primary key (id)
    );
create table relation_permissions (
        id int4 not null,
        provider_id int4,
        subscriber_id int4,
        primary key (id)
    );
create table reset_passwords (
        id int4 not null,
        expiry_date timestamp,
        generated_password varchar(1024),
        starttime timestamp,
        user_id int4,
        primary key (id)
    );
create table resources (
        id int4 not null,
        checksum varchar(255),
        content BYTEA,
        contentType varchar(64),
        created timestamp,
        deleted_flag bool,
        description varchar(1024),
        filename varchar(1024),
        filesize varchar(64),
        primary key (id)
    );
create table robinsons (
        id int4 not null,
        robinson_user_id int4,
        primary key (id)
    );
create table role_permissions (
        role_id int4 not null,
        permission_id int4 not null,
        primary key (role_id, permission_id)
    );
create table roles (
        id int4 not null,
        description varchar(64),
        rolename varchar(64) unique,
        primary key (id)
    );
create table rule_violations (
        id int4 not null,
        description varchar(1000),
        reason varchar(255),
        detector_user_id int4,
        violator_user_id int4,
        primary key (id)
    );
create table topics (
        id int4 not null,
        name varchar(1024),
        node bool,
        parent_id int4,
        primary key (id)
    );
create table user_addresses (
        user_data_id int4 not null,
        addresses_id int4 not null,
        primary key (user_data_id, addresses_id)
    );
create table user_contactmethods (
        user_data_id int4 not null,
        contactmethods_id int4 not null,
        primary key (user_data_id, contactmethods_id)
    );
create table user_contacts (
        user_data_id int4 not null,
        user_contact_id int4 not null,
        primary key (user_data_id, user_contact_id)
    );
create table user_contacts_allowed_contactmethods (
        id int4 not null,
        user_contact_id int4,
        user_contactmethod_id int4,
        primary key (id)
    );
create table user_credits (
        id int4 not null,
        credits int4,
        user_id int4,
        primary key (id)
    );
create table user_data (
        id int4 not null,
        birthname varchar(64),
        dateofbirth timestamp,
        firstname varchar(64),
        gender varchar(255),
        ip_address varchar(16),
        lastname varchar(64),
        locale varchar(12),
        primary_address_id int4,
        primary key (id)
    );
create table user_relation_permissions (
        user_relation_permission_id int4 not null,
        permission_id int4 not null,
        primary key (user_relation_permission_id, permission_id)
    );
create table user_resources (
        user_data_id int4 not null,
        resources_id int4 not null,
        primary key (user_data_id, resources_id)
    );
create table user_roles (
        user_id int4 not null,
        role_id int4 not null,
        primary key (user_id, role_id)
    );
create table userevents (
        id int4 not null,
        relationtype varchar(255),
        event_id int4,
        user_id int4,
        primary key (id)
    );
create table users (
        id int4 not null,
        active bool,
        locked bool,
        pw varchar(1024),
        salt varchar(8),
        username varchar(256) unique,
        user_data int4,
        primary key (id)
    );
create table zipcodes (
        id int4 not null,
        city varchar(128),
        zipcode varchar(10) not null,
        country_id int4,
        primary key (id)
    );


create type contactmethodType as enum (
	'EMAIL', 'MAIL', 'TELEFON', 'FAX', 'MOBILE', 'SMS', 'MESSENGER', 'INTERNET', 'NEWSGROUP'
);
create type difficultyType as enum (
	'BEGINNER','ADVANCED', 'EXPERT'
);
create type eventlocationType as enum (
	'INHOUSE', 'EVENTLOCATION'
);
CREATE TYPE gendertype AS ENUM (
	'MALE', 'FEMALE', 'INCORPORATION', 'UNDEFINED'
);
create type messageStateType as enum (
	'SIGNED', 'CONTACTED', 'EXPELLED', 'UNREPLIED', 'DELETED'
);
create type messageTypeType as enum (
	'MAIL', 'REPLY', 'NOTE'
);
create type visibilityType as enum (
	'INVISIBLE', 'APPROVED', 'DENIED'
);
create type rhythmType as enum (
	'DOES_NOT_REPEAT', 'DAILY', 'WEEKLY', 'MONTHLY', 'YEARLY', 'CUSTOM'
);
create type relationTypeType as enum (
	'REQUESTED', 'PROVIDED', 'SUBSCRIBED'
);

alter table contactmethods drop column contactmethod;    
alter table contactmethods add contactmethod contactmethodType;

alter table events drop column difficulty;    
alter table events add difficulty difficultyType;

alter table events drop column eventtype;    
alter table events add eventtype eventlocationType;

alter table user_data drop column gender;    
alter table user_data add gender genderType;

alter table messages drop column state;    
alter table messages add state messageStateType;

alter table messages drop column messagetype;    
alter table messages add messagetype messageTypeType;

alter table event_ratings drop column visibility;    
alter table event_ratings add visibility visibilityType;

alter table appointments drop column rhythm;    
alter table appointments add rhythm rhythmType;

alter table userevents drop column relationtype;    
alter table userevents add relationtype relationTypeType;
alter table addresses add constraint FK34207BA2FBFE6130 foreign key (zipcode_id) references zipcodes;
alter table addresses add constraint FK34207BA27EE00646 foreign key (federalstate_id) references federalstates;
alter table blacklisted_contacts add constraint FKA1253AB66926A1DE foreign key (blacklisted_id) references users;
alter table blacklisted_contacts add constraint FKA1253AB68CBCB659 foreign key (user_data_id) references user_data;
alter table event_locations add constraint FKCF58CBF960129CF5 foreign key (event_id) references events;
alter table event_locations add constraint FKCF58CBF92B00AA23 foreign key (event_location_id) references addresses;
alter table event_locations add constraint FKCF58CBF913E74E6D foreign key (appointment_id) references appointments;
alter table event_locations add constraint FKCF58CBF9B7488E45 foreign key (contactperson_id) references users;
alter table event_messages add constraint FKAB620D513F37AEE3 foreign key (event_location_id) references event_locations;
alter table event_messages add constraint FKAB620D51D45A1211 foreign key (message_id) references messages;
alter table event_ratings add constraint FK518F61D160129CF5 foreign key (event_id) references events;
alter table event_ratings add constraint FK518F61D18A2C3B2 foreign key (rater) references users;
alter table event_topics add constraint FK409D226960129CF5 foreign key (event_id) references events;
alter table event_topics add constraint FK409D226929B8538E foreign key (topic_id) references topics;
alter table events add constraint FKB307E1195C70CCF9 foreign key (categories_id) references categories;
alter table federalstates add constraint FK1A5486DFAE853FD9 foreign key (country_id) references countries;
alter table message_attachments add constraint FK64E05778311BBAC0 foreign key (resource_id) references resources;
alter table message_attachments add constraint FK64E05778D45A1211 foreign key (message_id) references messages;
alter table message_recipients add constraint FKF83BACB2468E2270 foreign key (recipient_email) references contactmethods;
alter table message_recipients add constraint FKF83BACB2D45A1211 foreign key (message_id) references messages;
alter table message_recipients add constraint FKF83BACB24D8C9121 foreign key (recipient_id) references users;
alter table messages add constraint FKE475014CFDCB7A68 foreign key (parent) references messages;
alter table messages add constraint FKE475014CCC2E8E55 foreign key (sender) references users;
alter table messages add constraint FKE475014CF13D458C foreign key (sender_email) references contactmethods;
alter table offered_event_locations add constraint FK56D7CBB5435B4D65 foreign key (event_location_data_id) references event_location_data;
alter table offered_event_locations add constraint FK56D7CBB5F969622F foreign key (user_id) references users;
alter table offered_event_locations add constraint FK56D7CBB57D3F4E49 foreign key (provider_id) references users;
alter table offered_event_locations add constraint FK56D7CBB56E2EC49D foreign key (user_address_id) references addresses;
alter table profile_federalstates add constraint FKC66646C9F969622F foreign key (user_id) references users;
alter table profile_federalstates add constraint FKC66646C97EE00646 foreign key (federalstate_id) references federalstates;
alter table profile_topics add constraint FKD90ECC7AF969622F foreign key (user_id) references users;
alter table profile_topics add constraint FKD90ECC7A29B8538E foreign key (topic_id) references topics;
alter table rating_descriptions add constraint FKAF90FB598A805C4 foreign key (event_ratings_id) references event_ratings;
alter table recommendations add constraint FK9357B7DAF969622F foreign key (user_id) references users;
alter table recommendations add constraint FK9357B7DAC50FA59F foreign key (recommended_id) references users;
alter table relation_permissions add constraint FK634032C15FEFE072 foreign key (subscriber_id) references users;
alter table relation_permissions add constraint FK634032C17D3F4E49 foreign key (provider_id) references users;
alter table reset_passwords add constraint FK35B79A48F969622F foreign key (user_id) references users;
alter table robinsons add constraint FKAAF79CBC06DC98 foreign key (robinson_user_id) references users;
alter table role_permissions add constraint FKEAD9D23B54140A59 foreign key (role_id) references roles;
alter table role_permissions add constraint FKEAD9D23BB7538E27 foreign key (permission_id) references permissions;
alter table rule_violations add constraint FK99170D11EC5AFAB6 foreign key (detector_user_id) references users;
alter table rule_violations add constraint FK99170D113CE73016 foreign key (violator_user_id) references users;
alter table topics add constraint FKCC42D924DE2E2233 foreign key (parent_id) references topics;
alter table user_addresses add constraint FK9188602E8CBCB659 foreign key (user_data_id) references user_data;
alter table user_addresses add constraint FK9188602EDEBFF13B foreign key (addresses_id) references addresses;
alter table user_contactmethods add constraint FKA59F56868CBCB659 foreign key (user_data_id) references user_data;
alter table user_contactmethods add constraint FKA59F568644566562 foreign key (contactmethods_id) references contactmethods;
alter table user_contacts add constraint FKE130BA475A197AAE foreign key (user_contact_id) references users;
alter table user_contacts add constraint FKE130BA478CBCB659 foreign key (user_data_id) references user_data;
alter table user_contacts_allowed_contactmethods add constraint FKE8DCB0015A197AAE foreign key (user_contact_id) references users;
alter table user_contacts_allowed_contactmethods add constraint FKE8DCB00164D34787 foreign key (user_contactmethod_id) references contactmethods;
alter table user_credits add constraint FK983F4C26F969622F foreign key (user_id) references users;
alter table user_data add constraint FK1435639E8089EA06 foreign key (primary_address_id) references addresses;
alter table user_relation_permissions add constraint FKDBE83EB5B7538E27 foreign key (permission_id) references permissions;
alter table user_relation_permissions add constraint FKDBE83EB53304507C foreign key (user_relation_permission_id) references relation_permissions;
alter table user_resources add constraint FKE734A2B1D0AAF549 foreign key (resources_id) references resources;
alter table user_resources add constraint FKE734A2B18CBCB659 foreign key (user_data_id) references user_data;
alter table user_roles add constraint FK7342994954140A59 foreign key (role_id) references roles;
alter table user_roles add constraint FK73429949F969622F foreign key (user_id) references users;
alter table userevents add constraint FK7DB388A460129CF5 foreign key (event_id) references events;
alter table userevents add constraint FK7DB388A4F969622F foreign key (user_id) references users;
alter table users add constraint FK6A68E08EFFD189B foreign key (user_data) references user_data;
alter table zipcodes add constraint FKF88385A5AE853FD9 foreign key (country_id) references countries;
create sequence hibernate_sequence;
