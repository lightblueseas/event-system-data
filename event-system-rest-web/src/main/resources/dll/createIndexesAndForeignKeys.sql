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
