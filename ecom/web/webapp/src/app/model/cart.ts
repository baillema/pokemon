import {Article} from './article';

export interface Cart {
  id?: number;
  bought_at?: Date;
  articles: Article[];
  total: number;
}
