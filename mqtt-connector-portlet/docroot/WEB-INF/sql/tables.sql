create table mqtt_Subscription (
	subscriptionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	topic VARCHAR(75) null,
	qos INTEGER,
	active_ INTEGER,
	lastSent DATE null,
	lastReceive DATE null
);