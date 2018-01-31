create table Band (id int8 not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, eventSet_id int8, primary key (id))
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table Location add constraint FKjec1acht3i3bko7702cajctl0 foreign key (eventSet_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, eventSet_id int8, primary key (id))
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table Location add constraint FKjec1acht3i3bko7702cajctl0 foreign key (eventSet_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, eventSet_id int8, primary key (id))
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table Location add constraint FKjec1acht3i3bko7702cajctl0 foreign key (eventSet_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, eventSet_id int8, primary key (id))
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table Location add constraint FKjec1acht3i3bko7702cajctl0 foreign key (eventSet_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, eventSet_id int8, primary key (id))
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table Location add constraint FKjec1acht3i3bko7702cajctl0 foreign key (eventSet_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, eventSet_id int8, primary key (id))
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table Location add constraint FKjec1acht3i3bko7702cajctl0 foreign key (eventSet_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
