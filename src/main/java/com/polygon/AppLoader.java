package com.polygon;

import com.polygon.util.JsonUtil;
import com.polygon.util.TelegramBotMethods;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppLoader {

	public static final ApplicationContext ctx = SpringApplication.run(AppLoader.class, new String[]{});
	private static final Object lock = new Object();

	static String test = "{\n" +
			"    \"deployment_status\": {\n" +
			"        \"url\": \"https://api.github.com/repos/NikichXP/taxi-service/deployments/40237230/statuses/65723842\",\n" +
			"        \"id\": 65723842,\n" +
			"        \"state\": \"success\",\n" +
			"        \"creator\": {\n" +
			"            \"login\": \"NikichXP\",\n" +
			"            \"id\": 3433520,\n" +
			"            \"avatar_url\": \"https://avatars1.githubusercontent.com/u/3433520?v=3\",\n" +
			"            \"gravatar_id\": \"\",\n" +
			"            \"url\": \"https://api.github.com/users/NikichXP\",\n" +
			"            \"html_url\": \"https://github.com/NikichXP\",\n" +
			"            \"followers_url\": \"https://api.github.com/users/NikichXP/followers\",\n" +
			"            \"following_url\": \"https://api.github.com/users/NikichXP/following{/other_user}\",\n" +
			"            \"gists_url\": \"https://api.github.com/users/NikichXP/gists{/gist_id}\",\n" +
			"            \"starred_url\": \"https://api.github.com/users/NikichXP/starred{/owner}{/repo}\",\n" +
			"            \"subscriptions_url\": \"https://api.github.com/users/NikichXP/subscriptions\",\n" +
			"            \"organizations_url\": \"https://api.github.com/users/NikichXP/orgs\",\n" +
			"            \"repos_url\": \"https://api.github.com/users/NikichXP/repos\",\n" +
			"            \"events_url\": \"https://api.github.com/users/NikichXP/events{/privacy}\",\n" +
			"            \"received_events_url\": \"https://api.github.com/users/NikichXP/received_events\",\n" +
			"            \"type\": \"User\",\n" +
			"            \"site_admin\": false\n" +
			"        },\n" +
			"        \"description\": \"\",\n" +
			"        \"target_url\": \"https://dashboard.heroku.com/apps/tachka/activity/builds/989de489-a197-47da-b98f-9eb36b8a4df8\",\n" +
			"        \"created_at\": \"2017-06-10T16:01:23Z\",\n" +
			"        \"updated_at\": \"2017-06-10T16:01:23Z\",\n" +
			"        \"deployment_url\": \"https://api.github.com/repos/NikichXP/taxi-service/deployments/40237230\",\n" +
			"        \"repository_url\": \"https://api.github.com/repos/NikichXP/taxi-service\"\n" +
			"    },\n" +
			"    \"deployment\": {\n" +
			"        \"url\": \"https://api.github.com/repos/NikichXP/taxi-service/deployments/40237230\",\n" +
			"        \"id\": 40237230,\n" +
			"        \"sha\": \"844afb17d51b43dae401bc163900ab21795aba30\",\n" +
			"        \"ref\": \"844afb17d51b43dae401bc163900ab21795aba30\",\n" +
			"        \"task\": \"deploy\",\n" +
			"        \"payload\": {\n" +
			"\n" +
			"        },\n" +
			"        \"environment\": \"tachka\",\n" +
			"        \"description\": \"Heroku\",\n" +
			"        \"creator\": {\n" +
			"            \"login\": \"NikichXP\",\n" +
			"            \"id\": 3433520,\n" +
			"            \"avatar_url\": \"https://avatars1.githubusercontent.com/u/3433520?v=3\",\n" +
			"            \"gravatar_id\": \"\",\n" +
			"            \"url\": \"https://api.github.com/users/NikichXP\",\n" +
			"            \"html_url\": \"https://github.com/NikichXP\",\n" +
			"            \"followers_url\": \"https://api.github.com/users/NikichXP/followers\",\n" +
			"            \"following_url\": \"https://api.github.com/users/NikichXP/following{/other_user}\",\n" +
			"            \"gists_url\": \"https://api.github.com/users/NikichXP/gists{/gist_id}\",\n" +
			"            \"starred_url\": \"https://api.github.com/users/NikichXP/starred{/owner}{/repo}\",\n" +
			"            \"subscriptions_url\": \"https://api.github.com/users/NikichXP/subscriptions\",\n" +
			"            \"organizations_url\": \"https://api.github.com/users/NikichXP/orgs\",\n" +
			"            \"repos_url\": \"https://api.github.com/users/NikichXP/repos\",\n" +
			"            \"events_url\": \"https://api.github.com/users/NikichXP/events{/privacy}\",\n" +
			"            \"received_events_url\": \"https://api.github.com/users/NikichXP/received_events\",\n" +
			"            \"type\": \"User\",\n" +
			"            \"site_admin\": false\n" +
			"        },\n" +
			"        \"created_at\": \"2017-06-10T16:00:41Z\",\n" +
			"        \"updated_at\": \"2017-06-10T16:00:41Z\",\n" +
			"        \"statuses_url\": \"https://api.github.com/repos/NikichXP/taxi-service/deployments/40237230/statuses\",\n" +
			"        \"repository_url\": \"https://api.github.com/repos/NikichXP/taxi-service\"\n" +
			"    },\n" +
			"    \"repository\": {\n" +
			"        \"id\": 87147194,\n" +
			"        \"name\": \"taxi-service\",\n" +
			"        \"full_name\": \"NikichXP/taxi-service\",\n" +
			"        \"owner\": {\n" +
			"            \"login\": \"NikichXP\",\n" +
			"            \"id\": 3433520,\n" +
			"            \"avatar_url\": \"https://avatars1.githubusercontent.com/u/3433520?v=3\",\n" +
			"            \"gravatar_id\": \"\",\n" +
			"            \"url\": \"https://api.github.com/users/NikichXP\",\n" +
			"            \"html_url\": \"https://github.com/NikichXP\",\n" +
			"            \"followers_url\": \"https://api.github.com/users/NikichXP/followers\",\n" +
			"            \"following_url\": \"https://api.github.com/users/NikichXP/following{/other_user}\",\n" +
			"            \"gists_url\": \"https://api.github.com/users/NikichXP/gists{/gist_id}\",\n" +
			"            \"starred_url\": \"https://api.github.com/users/NikichXP/starred{/owner}{/repo}\",\n" +
			"            \"subscriptions_url\": \"https://api.github.com/users/NikichXP/subscriptions\",\n" +
			"            \"organizations_url\": \"https://api.github.com/users/NikichXP/orgs\",\n" +
			"            \"repos_url\": \"https://api.github.com/users/NikichXP/repos\",\n" +
			"            \"events_url\": \"https://api.github.com/users/NikichXP/events{/privacy}\",\n" +
			"            \"received_events_url\": \"https://api.github.com/users/NikichXP/received_events\",\n" +
			"            \"type\": \"User\",\n" +
			"            \"site_admin\": false\n" +
			"        },\n" +
			"        \"private\": false,\n" +
			"        \"html_url\": \"https://github.com/NikichXP/taxi-service\",\n" +
			"        \"description\": null,\n" +
			"        \"fork\": false,\n" +
			"        \"url\": \"https://api.github.com/repos/NikichXP/taxi-service\",\n" +
			"        \"forks_url\": \"https://api.github.com/repos/NikichXP/taxi-service/forks\",\n" +
			"        \"keys_url\": \"https://api.github.com/repos/NikichXP/taxi-service/keys{/key_id}\",\n" +
			"        \"collaborators_url\": \"https://api.github.com/repos/NikichXP/taxi-service/collaborators{/collaborator}\",\n" +
			"        \"teams_url\": \"https://api.github.com/repos/NikichXP/taxi-service/teams\",\n" +
			"        \"hooks_url\": \"https://api.github.com/repos/NikichXP/taxi-service/hooks\",\n" +
			"        \"issue_events_url\": \"https://api.github.com/repos/NikichXP/taxi-service/issues/events{/number}\",\n" +
			"        \"events_url\": \"https://api.github.com/repos/NikichXP/taxi-service/events\",\n" +
			"        \"assignees_url\": \"https://api.github.com/repos/NikichXP/taxi-service/assignees{/user}\",\n" +
			"        \"branches_url\": \"https://api.github.com/repos/NikichXP/taxi-service/branches{/branch}\",\n" +
			"        \"tags_url\": \"https://api.github.com/repos/NikichXP/taxi-service/tags\",\n" +
			"        \"blobs_url\": \"https://api.github.com/repos/NikichXP/taxi-service/git/blobs{/sha}\",\n" +
			"        \"git_tags_url\": \"https://api.github.com/repos/NikichXP/taxi-service/git/tags{/sha}\",\n" +
			"        \"git_refs_url\": \"https://api.github.com/repos/NikichXP/taxi-service/git/refs{/sha}\",\n" +
			"        \"trees_url\": \"https://api.github.com/repos/NikichXP/taxi-service/git/trees{/sha}\",\n" +
			"        \"statuses_url\": \"https://api.github.com/repos/NikichXP/taxi-service/statuses/{sha}\",\n" +
			"        \"languages_url\": \"https://api.github.com/repos/NikichXP/taxi-service/languages\",\n" +
			"        \"stargazers_url\": \"https://api.github.com/repos/NikichXP/taxi-service/stargazers\",\n" +
			"        \"contributors_url\": \"https://api.github.com/repos/NikichXP/taxi-service/contributors\",\n" +
			"        \"subscribers_url\": \"https://api.github.com/repos/NikichXP/taxi-service/subscribers\",\n" +
			"        \"subscription_url\": \"https://api.github.com/repos/NikichXP/taxi-service/subscription\",\n" +
			"        \"commits_url\": \"https://api.github.com/repos/NikichXP/taxi-service/commits{/sha}\",\n" +
			"        \"git_commits_url\": \"https://api.github.com/repos/NikichXP/taxi-service/git/commits{/sha}\",\n" +
			"        \"comments_url\": \"https://api.github.com/repos/NikichXP/taxi-service/comments{/number}\",\n" +
			"        \"issue_comment_url\": \"https://api.github.com/repos/NikichXP/taxi-service/issues/comments{/number}\",\n" +
			"        \"contents_url\": \"https://api.github.com/repos/NikichXP/taxi-service/contents/{+path}\",\n" +
			"        \"compare_url\": \"https://api.github.com/repos/NikichXP/taxi-service/compare/{base}...{head}\",\n" +
			"        \"merges_url\": \"https://api.github.com/repos/NikichXP/taxi-service/merges\",\n" +
			"        \"archive_url\": \"https://api.github.com/repos/NikichXP/taxi-service/{archive_format}{/ref}\",\n" +
			"        \"downloads_url\": \"https://api.github.com/repos/NikichXP/taxi-service/downloads\",\n" +
			"        \"issues_url\": \"https://api.github.com/repos/NikichXP/taxi-service/issues{/number}\",\n" +
			"        \"pulls_url\": \"https://api.github.com/repos/NikichXP/taxi-service/pulls{/number}\",\n" +
			"        \"milestones_url\": \"https://api.github.com/repos/NikichXP/taxi-service/milestones{/number}\",\n" +
			"        \"notifications_url\": \"https://api.github.com/repos/NikichXP/taxi-service/notifications{?since,all,participating}\",\n" +
			"        \"labels_url\": \"https://api.github.com/repos/NikichXP/taxi-service/labels{/name}\",\n" +
			"        \"releases_url\": \"https://api.github.com/repos/NikichXP/taxi-service/releases{/id}\",\n" +
			"        \"deployments_url\": \"https://api.github.com/repos/NikichXP/taxi-service/deployments\",\n" +
			"        \"created_at\": \"2017-04-04T04:17:43Z\",\n" +
			"        \"updated_at\": \"2017-05-30T00:49:22Z\",\n" +
			"        \"pushed_at\": \"2017-06-10T16:00:35Z\",\n" +
			"        \"git_url\": \"git://github.com/NikichXP/taxi-service.git\",\n" +
			"        \"ssh_url\": \"git@github.com:NikichXP/taxi-service.git\",\n" +
			"        \"clone_url\": \"https://github.com/NikichXP/taxi-service.git\",\n" +
			"        \"svn_url\": \"https://github.com/NikichXP/taxi-service\",\n" +
			"        \"homepage\": null,\n" +
			"        \"size\": 220,\n" +
			"        \"stargazers_count\": 0,\n" +
			"        \"watchers_count\": 0,\n" +
			"        \"language\": \"HTML\",\n" +
			"        \"has_issues\": true,\n" +
			"        \"has_projects\": true,\n" +
			"        \"has_downloads\": true,\n" +
			"        \"has_wiki\": true,\n" +
			"        \"has_pages\": false,\n" +
			"        \"forks_count\": 0,\n" +
			"        \"mirror_url\": null,\n" +
			"        \"open_issues_count\": 0,\n" +
			"        \"forks\": 0,\n" +
			"        \"open_issues\": 0,\n" +
			"        \"watchers\": 0,\n" +
			"        \"default_branch\": \"master\"\n" +
			"    },\n" +
			"    \"sender\": {\n" +
			"        \"login\": \"NikichXP\",\n" +
			"        \"id\": 3433520,\n" +
			"        \"avatar_url\": \"https://avatars1.githubusercontent.com/u/3433520?v=3\",\n" +
			"        \"gravatar_id\": \"\",\n" +
			"        \"url\": \"https://api.github.com/users/NikichXP\",\n" +
			"        \"html_url\": \"https://github.com/NikichXP\",\n" +
			"        \"followers_url\": \"https://api.github.com/users/NikichXP/followers\",\n" +
			"        \"following_url\": \"https://api.github.com/users/NikichXP/following{/other_user}\",\n" +
			"        \"gists_url\": \"https://api.github.com/users/NikichXP/gists{/gist_id}\",\n" +
			"        \"starred_url\": \"https://api.github.com/users/NikichXP/starred{/owner}{/repo}\",\n" +
			"        \"subscriptions_url\": \"https://api.github.com/users/NikichXP/subscriptions\",\n" +
			"        \"organizations_url\": \"https://api.github.com/users/NikichXP/orgs\",\n" +
			"        \"repos_url\": \"https://api.github.com/users/NikichXP/repos\",\n" +
			"        \"events_url\": \"https://api.github.com/users/NikichXP/events{/privacy}\",\n" +
			"        \"received_events_url\": \"https://api.github.com/users/NikichXP/received_events\",\n" +
			"        \"type\": \"User\",\n" +
			"        \"site_admin\": false\n" +
			"    }\n" +
			"}";
	
	public static void main(String[] args) throws InterruptedException {
		synchronized (lock) {
			while (ctx == null) {
				Thread.sleep(10);
			}
		}
		System.out.println(TelegramBotMethods.sendMessage("34080460", "Telegram-app: Launched"));
		System.out.println(JsonUtil.of(test).get("repository.name"));
	}

	public static <T> T get(Class<T> clazz) {
		synchronized (lock) {}
		return ctx.getBean(clazz);
	}

	public static String getProperty(String s) {
		synchronized (lock) {}
		return ctx.getEnvironment().getProperty(s);
	}
}
