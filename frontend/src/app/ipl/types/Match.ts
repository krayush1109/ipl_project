
// src/app/ipl/types/Match.ts
export class Match {
    matchId: number;
    firstTeamId: number;
    secondTeamId: number;
    matchDate: Date;
    venue: string;
    result: string;
    status: string;
    winnerTeamId: number;
  
    constructor(
      matchId: number, firstTeamId: number, secondTeamId: number, matchDate: Date,
      venue: string, result: string, status: string, winnerTeamId: number
    ) {
      this.matchId = matchId;
      this.firstTeamId = firstTeamId;
      this.secondTeamId = secondTeamId;
      this.matchDate = matchDate;
      this.venue = venue;
      this.result = result;
      this.status = status;
      this.winnerTeamId = winnerTeamId;
    }
  
    displayInfo(): void {
      console.log(`Match ID: ${this.matchId}, Match Date: ${this.matchDate.toDateString()}, Venue: ${this.venue}`);
    }
  }
  
  // Example usage:
  const match = new Match(1, 1, 2, new Date('2025-04-15'), 'Wankhede Stadium', 'Mumbai Indians won by 6 wickets', 'Completed', 1);
  match.displayInfo();
  