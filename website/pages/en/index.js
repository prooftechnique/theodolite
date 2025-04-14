const React = require('react');

const CompLibrary = require('../../core/CompLibrary.js');

const MarkdownBlock = CompLibrary.MarkdownBlock; /* Used to read markdown */
const Container = CompLibrary.Container;
const GridBlock = CompLibrary.GridBlock;

const siteConfig = require(`${process.cwd()}/siteConfig.js`);

function imgUrl(img) {
  return `${siteConfig.baseUrl}img/${img}`;
}

function docUrl(doc, language) {
  return `${siteConfig.baseUrl}docs/${language ? `${language}/` : ''}${doc}`;
}

function pageUrl(page, language) {
  return siteConfig.baseUrl + (language ? `${language}/` : '') + page;
}

const SplashContainer = props => (
  <div className="homeContainer shadow">
    <div className="homeSplashFade">
      <div className="wrapper homeWrapper">{props.children}</div>
    </div>
  </div>
);

const Logo = props => (
  <div className="projectLogo">
    <img src={props.img_src} alt="Project Logo" />
  </div>
);

const ProjectTitle = () => (
      <div className="projectTitle inverse">
         {siteConfig.title}
    </div>

);

class HomeSplash extends React.Component {
  render() {
    const language = this.props.language || '';
    return (
      <SplashContainer>
        <div className="content">
          <img class="theodolite-logo" src={imgUrl(siteConfig.logo)} alt="Theodolite[_, _]" />
        <h2 className="inverseLight">Theodolite is a Profunctor Optics and Lenses library for Scala</h2>
      </div>
      </SplashContainer>
    );
  }
}

const Block = props => (
  <Container
    padding={['bottom', 'top']}
    id={props.id}
    background={props.background}>
    <GridBlock align="center" contents={props.children} layout={props.layout} />
  </Container>
);

const Features = () => (
  <Block layout="fourColumn">
    {[
      {
        title: 'Profunctional',
        content: 'Theodolite uses a Profunctor encoding for the internal representation of its optics. You can learn what is profunctor in the [profunctor](/Theodolite/docs/profunctors/profunctor) section.',
       },
      {
        title: 'Simple to use and easy to learn',
        content: 'Theodolite API was designed to resemble the Scala standard library.',
       },
      {
        title: 'Cats Friendly',
        content: 'Theodolite is built on top of [Cats](https://typelevel.org/cats/) and [Spire](https://typelevel.org/spire/)',
      },
    ]}
  </Block>
);

class Index extends React.Component {
  render() {
    const language = this.props.language || '';
    return (
      <div>
        <HomeSplash language={language} />
        <div className="mainContainer">
          <Features />
        </div>
      </div>
    );
  }
}

module.exports = Index;