alter table addresses drop constraint FK34207BA2FBFE6130;
alter table addresses drop constraint FK34207BA27EE00646;
alter table blacklisted_contacts drop constraint FKA1253AB66926A1DE;
alter table blacklisted_contacts drop constraint FKA1253AB64E23EC72;
alter table event_locations drop constraint FKCF58CBF9B0F067DE;
alter table event_locations drop constraint FKCF58CBF92B00AA23;
alter table event_locations drop constraint FKCF58CBF913E74E6D;
alter table event_locations drop constraint FKCF58CBF9B7488E45;
alter table event_messages drop constraint FKAB620D513F37AEE3;
alter table event_messages drop constraint FKAB620D51D45A1211;
alter table event_ratings drop constraint FK518F61D1B0F067DE;
alter table event_ratings drop constraint FK518F61D18A2C3B2;
alter table event_topics drop constraint FK409D2269B0F067DE;
alter table event_topics drop constraint FK409D226929B8538E;
alter table events drop constraint FKB307E1195C70CCF9;
alter table federalstates drop constraint FK1A5486DFAE853FD9;
alter table message_attachments drop constraint FK64E05778311BBAC0;
alter table message_attachments drop constraint FK64E05778D45A1211;
alter table message_recipients drop constraint FKF83BACB2468E2270;
alter table message_recipients drop constraint FKF83BACB2D45A1211;
alter table message_recipients drop constraint FKF83BACB24D8C9121;
alter table messages drop constraint FKE475014CFDCB7A68;
alter table messages drop constraint FKE475014CCC2E8E55;
alter table messages drop constraint FKE475014CF13D458C;
alter table offered_event_locations drop constraint FK56D7CBB56F80DAE4;
alter table offered_event_locations drop constraint FK56D7CBB5F969622F;
alter table offered_event_locations drop constraint FK56D7CBB57D3F4E49;
alter table offered_event_locations drop constraint FK56D7CBB56E2EC49D;
alter table profile_federalstates drop constraint FKC66646C9F969622F;
alter table profile_federalstates drop constraint FKC66646C97EE00646;
alter table profile_topics drop constraint FKD90ECC7AF969622F;
alter table profile_topics drop constraint FKD90ECC7A29B8538E;
alter table rating_descriptions drop constraint FKAF90FB598A805C4;
alter table recommendations drop constraint FK9357B7DAF969622F;
alter table recommendations drop constraint FK9357B7DAC50FA59F;
alter table relation_permissions drop constraint FK634032C15FEFE072;
alter table relation_permissions drop constraint FK634032C17D3F4E49;
alter table reset_passwords drop constraint FK35B79A48F969622F;
alter table robinsons drop constraint FKAAF79CBC06DC98;
alter table role_permissions drop constraint FKEAD9D23B54140A59;
alter table role_permissions drop constraint FKEAD9D23BB7538E27;
alter table rule_violations drop constraint FK99170D11EC5AFAB6;
alter table rule_violations drop constraint FK99170D113CE73016;
alter table topics drop constraint FKCC42D924DE2E2233;
alter table user_addresses drop constraint FK9188602E4E23EC72;
alter table user_addresses drop constraint FK9188602EDEBFF13B;
alter table user_contactmethods drop constraint FKA59F56864E23EC72;
alter table user_contactmethods drop constraint FKA59F568644566562;
alter table user_contacts drop constraint FKE130BA475A197AAE;
alter table user_contacts drop constraint FKE130BA474E23EC72;
alter table user_contacts_allowed_contactmethods drop constraint FKE8DCB0015A197AAE;
alter table user_contacts_allowed_contactmethods drop constraint FKE8DCB00164D34787;
alter table user_credits drop constraint FK983F4C26F969622F;
alter table user_data drop constraint FK1435639E8089EA06;
alter table user_relation_permissions drop constraint FKDBE83EB5B7538E27;
alter table user_relation_permissions drop constraint FKDBE83EB53304507C;
alter table user_resources drop constraint FKE734A2B1D0AAF549;
alter table user_resources drop constraint FKE734A2B14E23EC72;
alter table user_roles drop constraint FK7342994954140A59;
alter table user_roles drop constraint FK73429949F969622F;
alter table userevents drop constraint FK7DB388A4B0F067DE;
alter table userevents drop constraint FK7DB388A4F969622F;
alter table users drop constraint FK6A68E08B1644EB4;
alter table zipcodes drop constraint FKF88385A5AE853FD9;
drop table addresses;
drop table appointments;
drop table blacklisted_contacts;
drop table categories;
drop table contactmethods;
drop table countries;
drop table event_location_data;
drop table event_locations;
drop table event_messages;
drop table event_ratings;
drop table event_topics;
drop table events;
drop table federalstates;
drop table message_attachments;
drop table message_recipients;
drop table messages;
drop table offered_event_locations;
drop table permissions;
drop table profile_federalstates;
drop table profile_topics;
drop table rating_descriptions;
drop table recommendations;
drop table relation_permissions;
drop table reset_passwords;
drop table resources;
drop table robinsons;
drop table role_permissions;
drop table roles;
drop table rule_violations;
drop table topics;
drop table user_addresses;
drop table user_contactmethods;
drop table user_contacts;
drop table user_contacts_allowed_contactmethods;
drop table user_credits;
drop table user_data;
drop table user_relation_permissions;
drop table user_resources;
drop table user_roles;
drop table userevents;
drop table users;
drop table zipcodes;
drop sequence hibernate_sequence;
