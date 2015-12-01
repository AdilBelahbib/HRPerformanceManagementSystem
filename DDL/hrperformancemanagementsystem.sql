-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2015 at 09:34 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hrperformancemanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `action`
--

CREATE TABLE IF NOT EXISTS `action` (
  `id` int(11) NOT NULL,
  `descriptionAction` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bap`
--

CREATE TABLE IF NOT EXISTS `bap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateBAP` datetime NOT NULL,
  `StatutBAP` varchar(128) NOT NULL,
  `idFicheObjectifsTraites` int(11) DEFAULT NULL,
  `idFicheObjectifsRediges` int(11) DEFAULT NULL,
  `idFicheEvaluations` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifsTraites` (`idFicheObjectifsTraites`),
  KEY `idFicheObjectifsRediges` (`idFicheObjectifsRediges`),
  KEY `idFicheEvaluations` (`idFicheEvaluations`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bip`
--

CREATE TABLE IF NOT EXISTS `bip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateBIP` datetime NOT NULL,
  `idFicheObjectifsTraites` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifsTraites` (`idFicheObjectifsTraites`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `collaborateur`
--

CREATE TABLE IF NOT EXISTS `collaborateur` (
  `id` int(11) NOT NULL,
  `id_manager` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_manager` (`id_manager`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `collaborateur`
--

INSERT INTO `collaborateur` (`id`, `id_manager`) VALUES
(154, 151),
(155, 151);

-- --------------------------------------------------------

--
-- Table structure for table `entete`
--

CREATE TABLE IF NOT EXISTS `entete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebutIntervention` date DEFAULT NULL,
  `dateFinIntervention` date DEFAULT NULL,
  `role` varchar(64) DEFAULT NULL,
  `nombreJoursValorises` int(11) DEFAULT NULL,
  `idProjet` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poids` int(11) NOT NULL,
  `resultat` double DEFAULT NULL,
  `idEncadrant` int(11) NOT NULL,
  `idObjectif` int(11) NOT NULL,
  `idFicheEvaluations` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idEncadrant` (`idEncadrant`,`idObjectif`),
  KEY `foreign key` (`idObjectif`),
  KEY `idFicheEvaluations` (`idFicheEvaluations`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remarqueGenerale` varchar(1024) NOT NULL,
  `validation` bit(1) NOT NULL,
  `idEntete` int(11) DEFAULT NULL,
  `idCollaborateur` int(11) NOT NULL,
  `idEncadrant` int(11) NOT NULL,
  `idBap` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCollaborateur` (`idCollaborateur`),
  KEY `idEndacrant` (`idEncadrant`),
  KEY `idEntete` (`idEntete`),
  KEY `idBap` (`idBap`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `fiche_evaluations`
--

CREATE TABLE IF NOT EXISTS `fiche_evaluations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateEvaluation` datetime NOT NULL,
  `autorisationAcces` bit(1) DEFAULT b'1',
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCollaborateur` (`idCollaborateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `fiche_objectifs`
--

CREATE TABLE IF NOT EXISTS `fiche_objectifs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateFicheObjectifs` datetime NOT NULL,
  `autorisationAcces` bit(1) NOT NULL DEFAULT b'1',
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign key` (`idCollaborateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL,
  `autoformation` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `objectif`
--

CREATE TABLE IF NOT EXISTS `objectif` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descriptionObjectif` varchar(512) NOT NULL,
  `mesureObjectif` varchar(512) NOT NULL,
  `avancementObjectif` double NOT NULL DEFAULT '0',
  `idFicheObjectifs` int(11) DEFAULT NULL,
  `idFormation` int(11) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifs` (`idFicheObjectifs`),
  KEY `idFormation` (`idFormation`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `plan_amelioration`
--

CREATE TABLE IF NOT EXISTS `plan_amelioration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idBip` int(11) NOT NULL,
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_collaborateur` (`idCollaborateur`),
  KEY `id_bip` (`idBip`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeProfile` varchar(16) NOT NULL,
  `descriptionProfile` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codeProfile` (`codeProfile`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeProjet` varchar(16) NOT NULL,
  `nomProjet` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`id`, `codeProjet`, `nomProjet`) VALUES
(11, 'AB', 'blabla'),
(12, 'AB', 'blabla'),
(13, 'AB', 'blabla'),
(14, 'AB', 'blabla'),
(15, 'AB', 'blabla'),
(16, 'AB', 'blabla'),
(17, 'AB', 'blabla'),
(18, 'AB', 'blabla'),
(19, 'AB', 'blabla');

-- --------------------------------------------------------

--
-- Table structure for table `qualification_theme`
--

CREATE TABLE IF NOT EXISTS `qualification_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(128) NOT NULL,
  `qualification` varchar(128) NOT NULL,
  `remarque` varchar(512) DEFAULT NULL,
  `idFeedback` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFeedback` (`idFeedback`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(128) NOT NULL,
  `motDePasse` varchar(128) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `prenom` varchar(64) NOT NULL,
  `typeUtilisateur` varchar(2) NOT NULL DEFAULT 'C',
  `idProfile` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `idProfile` (`idProfile`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=156 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `motDePasse`, `nom`, `prenom`, `typeUtilisateur`, `idProfile`) VALUES
(149, 'adil@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB', 'Adil', 'E', NULL),
(150, 'hamza@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'TANJI', 'Hamza', 'A', NULL),
(151, 'tanji@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'TANJI', 'Hamza', 'M', NULL),
(154, 'belahbib@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB', 'Adil', 'C', NULL),
(155, 'belahbib2@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB2', 'Adil2', 'C', NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `action`
--
ALTER TABLE `action`
  ADD CONSTRAINT `action_ibfk_1` FOREIGN KEY (`id`) REFERENCES `plan_amelioration` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bap`
--
ALTER TABLE `bap`
  ADD CONSTRAINT `bap_ibfk_2` FOREIGN KEY (`idFicheObjectifsRediges`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bap_ibfk_3` FOREIGN KEY (`idFicheEvaluations`) REFERENCES `fiche_evaluations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bap_ibfk_4` FOREIGN KEY (`idFicheObjectifsTraites`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bip`
--
ALTER TABLE `bip`
  ADD CONSTRAINT `bip_ibfk_1` FOREIGN KEY (`idFicheObjectifsTraites`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD CONSTRAINT `collaborateur_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `collaborateur_ibfk_2` FOREIGN KEY (`id_manager`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `entete`
--
ALTER TABLE `entete`
  ADD CONSTRAINT `entete_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`idEncadrant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `evaluation_ibfk_2` FOREIGN KEY (`idObjectif`) REFERENCES `objectif` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `evaluation_ibfk_3` FOREIGN KEY (`idFicheEvaluations`) REFERENCES `fiche_evaluations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`idEncadrant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `feedback_ibfk_3` FOREIGN KEY (`idEntete`) REFERENCES `entete` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `feedback_ibfk_4` FOREIGN KEY (`idBap`) REFERENCES `bap` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fiche_evaluations`
--
ALTER TABLE `fiche_evaluations`
  ADD CONSTRAINT `fiche_evaluations_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fiche_objectifs`
--
ALTER TABLE `fiche_objectifs`
  ADD CONSTRAINT `fiche_objectifs_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_1` FOREIGN KEY (`id`) REFERENCES `plan_amelioration` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `objectif`
--
ALTER TABLE `objectif`
  ADD CONSTRAINT `objectif_ibfk_1` FOREIGN KEY (`idFicheObjectifs`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `objectif_ibfk_2` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id`),
  ADD CONSTRAINT `objectif_ibfk_3` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `plan_amelioration`
--
ALTER TABLE `plan_amelioration`
  ADD CONSTRAINT `plan_amelioration_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `plan_amelioration_ibfk_2` FOREIGN KEY (`idBip`) REFERENCES `bip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `qualification_theme`
--
ALTER TABLE `qualification_theme`
  ADD CONSTRAINT `qualification_theme_ibfk_1` FOREIGN KEY (`idFeedback`) REFERENCES `feedback` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`idProfile`) REFERENCES `profile` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
