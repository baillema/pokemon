interface Article {
  id?: number;
  name: string;
  price: number;
  description: string;
  shininess: boolean;
  level: number;
  picture: string;
  user?: User;
  mark: number;
}
