use Project

create table Organization
(
	OrgName varchar(50) primary key
)


create table Volunteer
(
	VolunteerName varchar(50) primary key,
	Age int,
	OrgName varchar(50),
	ProjName varchar(50),
	
	Foreign key (OrgName) references [dbo].[Organization](OrgName),
	Foreign key (ProjName) references [dbo].[Project](ProjName)
)

create table Project
(
	ProjName varchar(50) primary key,
	ProjDescription varchar(250),
	ProjBudget int,
	OrgName varchar(50),
	TeamLead varchar(50),
	Foreign key (OrgName) references [dbo].[Organization](OrgName)

)

create table Beneficiary
(
	BenefName varchar(50) primary key,
	Age int,
	AssessmentMarks int,
	AssessedByVol varchar(50)
)

create table Donation
(
	
	DonationID int primary key,
	DonorName varchar(50),
	DonationDate varchar(50),
	Donationtype int,
	ProjName varchar(50),
	Foreign key (ProjName) references [dbo].[Project](ProjName),
	FOREIGN KEY (ProjName) REFERENCES Project(ProjName)

)
create table Disbursment
(
	DisbursmentID int primary key,
	DonationID int,
	BenefName varchar(50), 
	Disbursmentdate varchar(10),
	Foreign key (DonationID) references [dbo].[Donation](DonationID),
	Foreign key (BenefName) references [dbo].[Beneficiary](BenefName)
)


create table Donor
(
	DonorName varchar(50) primary key,
	Age int
)


create table Items
(
	DonationID int primary key,
	ItemName varchar(50),
	Amount int,
	AmountLeft int,
	Foreign key (DonationID) references [dbo].[Donation](DonationID),
)


create table Funds
(
	DonationID int primary key,
	Amount int,
	Fundstype int,
	Foreign key (DonationID) references [dbo].[Donation](DonationID),
)


create table Pledge
(
	DonationID int primary key,
	releasedate varchar(50),
	pledgedate varchar(50),
	Foreign key (DonationID) references [dbo].[Donation](DonationID),
)

create table Loan
(
	DonationID int primary key,
	returndate varchar(50),
	Foreign key (DonationID) references [dbo].[Donation](DonationID),
)
