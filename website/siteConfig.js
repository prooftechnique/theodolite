const apiUrl = "/Theodolite/api/theodolite/index.html";

const siteConfig = {
  title: 'Theodolite[_, _]',
  tagline: 'Profunctor optics and lenses library for Scala',
  url: 'https://proofte.ch/Theodolite',
  baseUrl: '/Theodolite/',
  apiUrl,
  favicon: 'img/favicon/favicon.ico',
  logo: '/theodolite-transparent.png',
  repoUrl: 'https://github.com/prooftechnique/theodolite',
  customDocsPath: "docs/target/mdoc",
  projectName: 'Theodolite',
  organizationName: 'prooftechnique',
  docsSideNavCollapsible: true,
  headerLinks: [
    {href: '/Theodolite/docs/overview', label: 'Getting Started'},
    {href: apiUrl, label: "API Docs"},
    {href: 'https://github.com/prooftechnique/theodolite', label: 'GitHub'}
  ],
  colors: {
    primaryColor: '#B9459A',
    secondaryColor: '#8A3373',
  },
  copyright: `Copyright © ${new Date().getFullYear()} Sagi Fogel (foldl)`,
  usePrism: ['scala'],
  highlight: {
    theme: 'atom-one-dark',
  },
  separateCss: ["api"],
  scripts: ['https://buttons.github.io/buttons.js'],
  onPageNav: 'separate',
  cleanUrl: true
};

module.exports = siteConfig;