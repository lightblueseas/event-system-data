# event-system-data

Parent project that holds module projects for the persistence of event data.

The project holds backend data for event data management.

## License

The source code comes under the liberal MIT License, making event-system-data great for all types of applications for event data management.

# Build status and latest maven version
[![Build Status](https://travis-ci.org/lightblueseas/event-system-data.svg?branch=master)](https://travis-ci.org/lightblueseas/event-system-data)

## Maven Central

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/event-system-data/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/event-system-data)

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~event-system-data~~~) for latest snapshots and releases.

Add the following maven dependencies to your project `pom.xml` if you want to import the core functionality:

You can first define the version properties:

	<properties>
			...
		<!-- event-system-data version -->
		<event-system-data.version>3.11.0</event-system-data.version>
		<event-system-business.version>${event-system-data.version}</event-system-business.version>
		<event-system-domain.version>${event-system-data.version}</event-system-domain.version>
		<event-system-entities.version>${event-system-data.version}</event-system-entities.version>
		<event-system-init.version>${event-system-data.version}</event-system-init.version>
		<event-system-rest-api.version>${event-system-data.version}</event-system-rest-api.version>
		<event-system-rest-client.version>${event-system-data.version}</event-system-rest-client.version>
		<event-system-rest-web.version>${event-system-data.version}</event-system-rest-web.version>
			...
	</properties>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of event-system-business:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>event-system-business</artifactId>
				<version>${event-system-business.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of event-system-domain:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>event-system-domain</artifactId>
				<version>${event-system-domain.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of event-system-entities:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>event-system-entities</artifactId>
				<version>${event-system-entities.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of event-system-init:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>event-system-init</artifactId>
				<version>${event-system-init.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of event-system-rest-api:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>event-system-rest-api</artifactId>
				<version>${event-system-rest-api.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of event-system-rest-client:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>event-system-rest-client</artifactId>
				<version>${event-system-rest-client.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of event-system-rest-web:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>event-system-rest-web</artifactId>
				<version>${event-system-rest-web.version}</version>
			</dependency>
			...
		</dependencies>

## Want to Help and improve it? ###

The source code for event-system-data are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/event-system-data/fork](https://github.com/lightblueseas/event-system-data/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/event-system-data/pull/new/master).

Don't forget to add new units tests on your changes.

## Contacting the Developer

Do not hesitate to contact the event-system-data developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/event-system-data/issues).

## Note

No animals were harmed in the making of this library.

# Donate

If you like this library, please consider a donation through 
<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fevent-system-data" target="_blank">
<img src="http://button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0">
</a>