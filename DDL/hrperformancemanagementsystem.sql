-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2015 at 04:30 PM
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

--
-- Dumping data for table `action`
--

INSERT INTO `action` (`id`, `descriptionAction`) VALUES
(2, 'tstststsfdsdf'),
(4, 'dfddfdd'),
(5, 'lkjkljlkjlkj'),
(6, 'dscscscsxcsxc');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `bap`
--

INSERT INTO `bap` (`id`, `dateBAP`, `StatutBAP`, `idFicheObjectifsTraites`, `idFicheObjectifsRediges`, `idFicheEvaluations`) VALUES
(1, '2015-12-16 00:00:00', 'ANNULE', 1, 2, 1),
(2, '2015-12-02 00:00:00', 'VALIDE', 2, 3, 2),
(3, '2015-12-08 00:00:00', 'EN_ATTENTE', 3, 3, 3),
(4, '2015-12-20 00:00:00', 'REJETE', 4, 5, 4),
(5, '2015-12-20 00:00:00', 'REJETE', 4, 5, 4);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `bip`
--

INSERT INTO `bip` (`id`, `dateBIP`, `idFicheObjectifsTraites`) VALUES
(1, '2015-12-03 00:00:00', 3),
(2, '2015-12-10 00:00:00', 4);

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
(156, 151),
(157, 151),
(155, 159),
(158, 159);

-- --------------------------------------------------------

--
-- Table structure for table `demande_bip`
--

CREATE TABLE IF NOT EXISTS `demande_bip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDemande` date NOT NULL,
  `idCollaborateur` int(11) NOT NULL,
  `idEncadrant` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCollaborateur` (`idCollaborateur`),
  KEY `idEncadrant` (`idEncadrant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `entete`
--

INSERT INTO `entete` (`id`, `dateDebutIntervention`, `dateFinIntervention`, `role`, `nombreJoursValorises`, `idProjet`) VALUES
(1, '2015-12-07', '2015-12-17', 'aqsdqsdqs', 35, 15),
(2, '2015-12-10', '2015-12-17', 'qsdqsdq', 123, 13);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `evaluation`
--

INSERT INTO `evaluation` (`id`, `poids`, `resultat`, `idEncadrant`, `idObjectif`, `idFicheEvaluations`) VALUES
(1, 121, 4521, 149, 1, 2),
(2, 123, NULL, 149, 2, 2),
(3, 120, 110, 149, 3, 3);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `remarqueGenerale`, `validation`, `idEntete`, `idCollaborateur`, `idEncadrant`, `idBap`) VALUES
(1, 'wdwsddfsfsdfsd', b'1', 1, 154, 149, 1),
(2, 'cxcxcvxfvfgfgfgfdfs', b'0', 2, 155, 149, 2);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `fiche_evaluations`
--

INSERT INTO `fiche_evaluations` (`id`, `dateEvaluation`, `autorisationAcces`, `idCollaborateur`) VALUES
(1, '2015-12-07 00:00:00', b'1', 154),
(2, '2015-12-09 00:00:00', b'1', 154),
(3, '2015-12-25 00:00:00', b'1', 155),
(4, '2015-12-02 00:00:00', b'1', 154),
(5, '2015-12-05 00:00:00', b'1', 155);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `fiche_objectifs`
--

INSERT INTO `fiche_objectifs` (`id`, `dateFicheObjectifs`, `autorisationAcces`, `idCollaborateur`) VALUES
(1, '2015-12-07 00:00:00', b'1', 154),
(2, '2015-12-24 00:00:00', b'1', 154),
(3, '2015-12-09 00:00:00', b'1', 156),
(4, '2015-12-22 00:00:00', b'1', 155),
(5, '2015-12-23 00:00:00', b'1', 155);

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL,
  `autoformation` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`id`, `autoformation`) VALUES
(1, b'1'),
(3, b'0');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `objectif`
--

INSERT INTO `objectif` (`id`, `descriptionObjectif`, `mesureObjectif`, `avancementObjectif`, `idFicheObjectifs`, `idFormation`, `idProjet`) VALUES
(1, 'fsdqsdqsdqdqdqxq', 'qsdqsdqsdqsd', 0, 3, NULL, 11),
(2, 'gjghughughu', 'dtdsrtsrtsr', 0, 4, NULL, 12),
(3, 'cghghcghcgh', 'xgxfgfxgxfg', 0, 2, NULL, 14),
(4, 'xfgxfgxgxc', 'sfgsfgsf', 0, 1, NULL, 15),
(5, 'qeqxqsdqsdqxq', 'qdfdfsdfcxvx', 0, NULL, 1, 11),
(6, 'jkvbhjvhjvhj', 'xgxfgxxvcvxdd', 0, NULL, 1, 11);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `plan_amelioration`
--

INSERT INTO `plan_amelioration` (`id`, `idBip`, `idCollaborateur`) VALUES
(1, 1, 154),
(2, 2, 155),
(3, 1, 154),
(4, 2, 157),
(5, 1, 155),
(6, 2, 155);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`id`, `codeProfile`, `descriptionProfile`) VALUES
(1, 'DEV', 'Developpeur'),
(2, 'DRH', 'Directeur des ressources Humaines'),
(3, 'RAD', 'Recherche & Developpement');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=161 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `motDePasse`, `nom`, `prenom`, `typeUtilisateur`, `idProfile`) VALUES
(149, 'adil@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB', 'Adil', 'E', NULL),
(150, 'hamza@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'TANJI', 'Hamza', 'A', NULL),
(151, 'tanji@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'TANJI', 'Hamza', 'M', NULL),
(154, 'belahbib@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB', 'Adil', 'C', NULL),
(155, 'belahbib2@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB2', 'Adil2', 'C', NULL),
(156, 'belahbib3@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB2', 'Adil2', 'C', NULL),
(157, 'belahbib4@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB2', 'Adil2', 'C', NULL),
(158, 'belahbib5@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB2', 'Adil2', 'C', NULL),
(159, 'tanji2@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'TANJI', 'Hamza', 'M', NULL),
(160, 'tanji3@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'TANJI', 'Hamza', 'M', NULL);

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
-- Constraints for table `demande_bip`
--
ALTER TABLE `demande_bip`
  ADD CONSTRAINT `demande_bip_ibfk_2` FOREIGN KEY (`idEncadrant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demande_bip_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
