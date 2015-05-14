-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:3306
-- Généré le :  Jeu 14 Mai 2015 à 15:18
-- Version du serveur :  5.5.38
-- Version de PHP :  5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `GPubli`
--

-- --------------------------------------------------------

--
-- Structure de la table `Author`
--

CREATE TABLE `Author` (
`author_id` int(11) NOT NULL,
  `firstname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ldap_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Publication`
--

CREATE TABLE `Publication` (
`publication_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `type_id` int(11) NOT NULL,
  `resume` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `book_title` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `journal` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `url` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `Publication`
--

INSERT INTO `Publication` (`publication_id`, `date`, `type_id`, `resume`, `book_title`, `title`, `journal`, `url`) VALUES
(1, '2015-05-04', 1, 'SQSDQSDQSDQSD', 'SDQSD', 'QSDQSD', 'QSDQDSQD', 'QSDQSDQSDQSD'),
(2, '2015-05-14', 1, 'ERERT', 'ZERZEREZ', 'ZERZER', 'EZRZR', 'ZERZRER');

-- --------------------------------------------------------

--
-- Structure de la table `Repository`
--

CREATE TABLE `Repository` (
  `publication_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Team`
--

CREATE TABLE `Team` (
`team_id` int(11) NOT NULL,
  `name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `thumbnail` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Type`
--

CREATE TABLE `Type` (
`type_id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Author`
--
ALTER TABLE `Author`
 ADD PRIMARY KEY (`author_id`);

--
-- Index pour la table `Publication`
--
ALTER TABLE `Publication`
 ADD PRIMARY KEY (`publication_id`);

--
-- Index pour la table `Team`
--
ALTER TABLE `Team`
 ADD PRIMARY KEY (`team_id`);

--
-- Index pour la table `Type`
--
ALTER TABLE `Type`
 ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Author`
--
ALTER TABLE `Author`
MODIFY `author_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Publication`
--
ALTER TABLE `Publication`
MODIFY `publication_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Team`
--
ALTER TABLE `Team`
MODIFY `team_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Type`
--
ALTER TABLE `Type`
MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT;