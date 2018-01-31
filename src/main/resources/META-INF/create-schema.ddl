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
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, user_id int8, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), user_type int4, cart_id int8, primary key (id))
alter table Cart add constraint FK7toxf0y2a3mewe83du44h29fi foreign key (user_id) references users
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, user_id int8, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), user_type int4, cart_id int8, primary key (id))
alter table Cart add constraint FK7toxf0y2a3mewe83du44h29fi foreign key (user_id) references users
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, user_id int8, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), user_type int4, cart_id int8, primary key (id))
alter table Cart add constraint FK7toxf0y2a3mewe83du44h29fi foreign key (user_id) references users
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
