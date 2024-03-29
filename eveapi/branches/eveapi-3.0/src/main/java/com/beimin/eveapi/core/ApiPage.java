package com.beimin.eveapi.core;

public enum ApiPage {
	ACCOUNT_STATUS("AccountStatus"), //
	CHARACTERS("Characters"), //
	ACCOUNT_BALANCE("AccountBalance"), //
	ASSET_LIST("AssetList"), //
	UPCOMING_CALENDAR_EVENTS("UpcomingCalendarEvents"), //
	CONTACT_LIST("ContactList"), //
	CONTACT_NOTIFICATIONS("ContactNotifications"), //
	FACT_WAR_STATS("FacWarStats"), //
	INDUSTRY_JOBS("IndustryJobs"), //
	KILL_LOG("KillLog"), //
	MAIL_BODIES("MailBodies"), //
	MAILING_LISTS("MailingLists"), //
	MAIL_MESSAGES("MailMessages"), //
	MARKET_ORDERS("MarketOrders"), //
	MEDALS("Medals"), //
	NOTIFICATIONS("Notifications"), //
	RESEARCH("Research"), //
	CHARACTER_SHEET("CharacterSheet"), //
	SKILL_IN_TRAINING("SkillInTraining"), //
	SKILL_QUEUE("SkillQueue"), //
	STANDINGS("Standings"), //
	WALLET_JOURNAL("WalletJournal"), //
	WALLET_TRANSACTIONS("WalletTransactions"), //
	CONTAINER_LOG("ContainerLog"), //
	MEMBER_MEDALS("MemberMedals"), //
	MEMBER_SECURITY_LOG("MemberSecurityLog"), //
	MEMBER_SECURITY("MemberSecurity"), //
	MEMBER_TRACKING("MemberTracking"), //
	SHAREHOLDERS("Shareholders"), //
	CORPORATION_SHEET("CorporationSheet"), //
	STARBASE_DETAIL("StarbaseDetail"), //
	STARBASE_LIST("StarbaseList"), //
	TITLES("Titles"), //
	ALLIANCE_LIST("AllianceList"), //
	CERTIFICATE_TREE("CertificateTree"), //
	CHARACTER_ID("CharacterID"), //
	CHARACTER_NAME("CharacterName"), //
	CONQUERABLE_STATION_LIST("ConquerableStationList"), //
	ERROR_LIST("ErrorList"), //
	FACT_WAR_TOP_STATS("FacWarTopStats"), //
	REF_TYPES("RefTypes"), //
	SKILL_TREE("SkillTree"), //
	FACTION_WAR_SYSTEMS("FacWarSystems"), //
	JUMPS("Jumps"), //
	KILLS("Kills"), //
	SOVEREIGNTY("Sovereignty"), //
	SERVER_STATUS("ServerStatus"), //
	CHARACTER_INFO("CharacterInfo");

	private final String url;

	private ApiPage(String url) {
		this.url = url;
	}

	public String getPage() {
		return url;
	}
}