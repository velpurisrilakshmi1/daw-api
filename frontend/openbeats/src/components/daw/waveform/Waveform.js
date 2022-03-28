
import React, { Component } from 'react';
import WaveSurfer from 'wavesurfer.js';

import './Waveform.css';

class Waveform extends Component {  
  state = {
    playing: false,
    url : 'https://www.mfiles.co.uk/mp3-downloads/gs-cd-track2.mp3'
  };
  

  componentDidMount() {
    const track = document.querySelector("#track"+this.props.id);

    this.waveform = WaveSurfer.create({
    //   barWidth: 2,
      cursorWidth: 3,
      container: '#waveform'+this.props.id,
      backend: 'WebAudio',
      height: 40,
      progressColor: '#2D5BFF',
      responsive: true,
      waveColor: '#EFEFEF',
      cursorColor: 'transparent',
    });

    this.waveform.load(track);
  };
  componentDidUpdate(prevProps) {
    if(this.props.source != prevProps.source) // Check if it's a new user, you can also use some unique property, like the ID  (this.props.user.id !== prevProps.user.id)
    {
        this.waveform.destroy()
        const track = document.querySelector("#track"+this.props.id);
        var blobUrl = URL.createObjectURL(this.props.source)
        var srcElement = document.getElementsByTagName("audio")[0];
        srcElement.src=blobUrl
        this.waveform = WaveSurfer.create({
            // barWidth: 0.5,
            cursorWidth: 1,
            container: '#waveform'+this.props.id,
            backend: 'WebAudio',
            height: 40,
            progressColor: '#2D5BFF',
            responsive: true,
            waveColor: '#EFEFEF',
            cursorColor: 'transparent',
          });
        this.waveform.load(track);
        // this.waveform.load(blobUrl);
    }
  }
  componentWillUnmount(){
    this.waveform.destroy()
  } 
  
  handlePlay = () => {
    this.setState({ playing: !this.state.playing });
    this.waveform.playPause();
  };

  // getSource = () => this.props.source ? this.props.source :this.state.url;
  
  render() {

    return (
      <div className="WaveformContianer">
        <button onClick={this.handlePlay} className="PlayButton">
          {!this.state.playing ? '▷' : '||'}
        </button>
        <div id={"waveform"+this.props.id} className="Wave"/>
        <audio id={"track"+this.props.id} src={this.state.url} />
      </div>
    );
  }
};

export default Waveform;