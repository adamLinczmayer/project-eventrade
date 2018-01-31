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
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Order (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table Order_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table Order_LineItem add constraint UK_bly8c6ed16i8sudnwqh045coi unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK2ce8hqxg31wwu3otdyqt2q52l foreign key (order_id) references Order
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table Order add constraint FKg6nalj3h0iv166u2qby5rto57 foreign key (users_id) references users
alter table Order_LineItem add constraint FKtkwv88d2e1uhrvc63v68kdyhf foreign key (lineItems_id) references LineItem
alter table Order_LineItem add constraint FK77nagb4rps7fqgn4lh7nglh06 foreign key (Order_id) references Order
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Order (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table Order_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table Order_LineItem add constraint UK_bly8c6ed16i8sudnwqh045coi unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK2ce8hqxg31wwu3otdyqt2q52l foreign key (order_id) references Order
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table Order add constraint FKg6nalj3h0iv166u2qby5rto57 foreign key (users_id) references users
alter table Order_LineItem add constraint FKtkwv88d2e1uhrvc63v68kdyhf foreign key (lineItems_id) references LineItem
alter table Order_LineItem add constraint FK77nagb4rps7fqgn4lh7nglh06 foreign key (Order_id) references Order
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Order (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table Order_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table Order_LineItem add constraint UK_bly8c6ed16i8sudnwqh045coi unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK2ce8hqxg31wwu3otdyqt2q52l foreign key (order_id) references Order
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table Order add constraint FKg6nalj3h0iv166u2qby5rto57 foreign key (users_id) references users
alter table Order_LineItem add constraint FKtkwv88d2e1uhrvc63v68kdyhf foreign key (lineItems_id) references LineItem
alter table Order_LineItem add constraint FK77nagb4rps7fqgn4lh7nglh06 foreign key (Order_id) references Order
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Order (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table Order_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table Order_LineItem add constraint UK_bly8c6ed16i8sudnwqh045coi unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK2ce8hqxg31wwu3otdyqt2q52l foreign key (order_id) references Order
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table Order add constraint FKg6nalj3h0iv166u2qby5rto57 foreign key (users_id) references users
alter table Order_LineItem add constraint FKtkwv88d2e1uhrvc63v68kdyhf foreign key (lineItems_id) references LineItem
alter table Order_LineItem add constraint FK77nagb4rps7fqgn4lh7nglh06 foreign key (Order_id) references Order
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table Order (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table Order_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table Order_LineItem add constraint UK_bly8c6ed16i8sudnwqh045coi unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK2ce8hqxg31wwu3otdyqt2q52l foreign key (order_id) references Order
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table Order add constraint FKg6nalj3h0iv166u2qby5rto57 foreign key (users_id) references users
alter table Order_LineItem add constraint FKtkwv88d2e1uhrvc63v68kdyhf foreign key (lineItems_id) references LineItem
alter table Order_LineItem add constraint FK77nagb4rps7fqgn4lh7nglh06 foreign key (Order_id) references Order
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK6jhw3qeewupya07myovroetaa foreign key (order_id) references orders
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK6jhw3qeewupya07myovroetaa foreign key (order_id) references orders
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK6jhw3qeewupya07myovroetaa foreign key (order_id) references orders
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, order_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK6jhw3qeewupya07myovroetaa foreign key (order_id) references orders
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Cart_LineItem (Cart_id int8 not null, lineItems_id int8 not null, primary key (Cart_id, lineItems_id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table Cart_LineItem add constraint UK_la0nvjcnxfpmm9t8usj8k3uww unique (lineItems_id)
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Cart_LineItem add constraint FKhwiwvp67ad7nqi1ml7uhchbxd foreign key (lineItems_id) references LineItem
alter table Cart_LineItem add constraint FKhud8vkbt5vr1dmeh174adyjnp foreign key (Cart_id) references Cart
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Cart_LineItem (Cart_id int8 not null, lineItems_id int8 not null, primary key (Cart_id, lineItems_id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table Cart_LineItem add constraint UK_la0nvjcnxfpmm9t8usj8k3uww unique (lineItems_id)
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Cart_LineItem add constraint FKhwiwvp67ad7nqi1ml7uhchbxd foreign key (lineItems_id) references LineItem
alter table Cart_LineItem add constraint FKhud8vkbt5vr1dmeh174adyjnp foreign key (Cart_id) references Cart
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
create table Band (id  bigserial not null, musicStyle varchar(255), name varchar(255), primary key (id))
create table Cart (id  bigserial not null, primary key (id))
create table Cart_LineItem (Cart_id int8 not null, lineItems_id int8 not null, primary key (Cart_id, lineItems_id))
create table Event (id  bigserial not null, date timestamp, location_id int8, primary key (id))
create table event_bands (events_id int8 not null, bands_id int8 not null, primary key (events_id, bands_id))
create table LineItem (id  bigserial not null, quantity int4, cart_id int8, ticket_id int8, primary key (id))
create table Location (id  bigserial not null, address varchar(255) not null, capacity int4 not null, name varchar(255) not null, primary key (id))
create table orders (id  bigserial not null, status varchar(255), users_id int8, primary key (id))
create table orders_LineItem (Order_id int8 not null, lineItems_id int8 not null, primary key (Order_id, lineItems_id))
create table Ticket (id  bigserial not null, price float4, ticketType varchar(255), event_id int8, primary key (id))
create table users (id  bigserial not null, card_number varchar(255), email varchar(255), full_name varchar(255), password varchar(255), user_name varchar(255), type varchar(255), cart_id int8, primary key (id))
alter table Cart_LineItem add constraint UK_la0nvjcnxfpmm9t8usj8k3uww unique (lineItems_id)
alter table orders_LineItem add constraint UK_kggnk85xrfsv7t8ndq9r0tsil unique (lineItems_id)
alter table Cart_LineItem add constraint FKhwiwvp67ad7nqi1ml7uhchbxd foreign key (lineItems_id) references LineItem
alter table Cart_LineItem add constraint FKhud8vkbt5vr1dmeh174adyjnp foreign key (Cart_id) references Cart
alter table Event add constraint FKgdruo5qb3kca4ohxo14cedene foreign key (location_id) references Location
alter table event_bands add constraint FK2f226i26lxgmrpvkhoj4j8enm foreign key (bands_id) references Band
alter table event_bands add constraint FKrm32iw4wcb3itygg4tf72f7je foreign key (events_id) references Event
alter table LineItem add constraint FK99hs9f960ak8l7g15xfntdv2y foreign key (cart_id) references Cart
alter table LineItem add constraint FK5dyn1ap0vyk1fdmtqmrtwsa55 foreign key (ticket_id) references Ticket
alter table orders add constraint FKe6k45xxoin4fylnwg2jkehwjf foreign key (users_id) references users
alter table orders_LineItem add constraint FKstgmp3fioj1hskkbfxi7mf3qb foreign key (lineItems_id) references LineItem
alter table orders_LineItem add constraint FKhq1tr71xq9n96vypr9na1gh6w foreign key (Order_id) references orders
alter table Ticket add constraint FKsotv3qctce5ggaewd002dd71s foreign key (event_id) references Event
alter table users add constraint FKri6ogcunypjm24gonwvo6lbfs foreign key (cart_id) references Cart
